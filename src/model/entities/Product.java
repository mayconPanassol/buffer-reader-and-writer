package model.entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Product {

	private String product;
	private Integer quantity;
	private Double price;
	
	ArrayList<Product> list = new ArrayList<Product>();

	public Product() {
	}
	
	public Product(String product, Integer quantity, Double price) {
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void readerFile(String path) {

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = null;

			while ((line = br.readLine()) != null) {
				
				String[] vectLine = line.split(",");
				String product = vectLine[0];
				
				int quantity= Integer.valueOf(vectLine[2]);
				double price = Double.valueOf(vectLine[1]);
				
				list.add(new Product(product, quantity, price));				
			
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}
	
	public void createNewFile(String path) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
		
			for (Product listProduct : list) {
				bw.write(listProduct.getProduct() + "," + listProduct.getPrice() + "," + listProduct.getQuantity() + "teste1");
				bw.newLine();
			}
			
		}
		catch (IOException e){
		System.out.println("Error: " + e.getMessage());
		}
		
	}
	

}
