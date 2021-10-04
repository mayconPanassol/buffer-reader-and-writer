package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {

	Locale.setDefault(Locale.US);	
		
	Scanner sc = new Scanner(System.in);	
		
	Product product = new Product();
	
	System.out.print("Input the local: ");
	String path = sc.nextLine();
	
	product.readerFile(path);
	
	System.out.print("Input the local where will be created the new file: ");
	path = sc.nextLine();
	
	product.createNewFile(path);
	
	System.out.println("File createad.");
	
	sc.close();

	}

}
