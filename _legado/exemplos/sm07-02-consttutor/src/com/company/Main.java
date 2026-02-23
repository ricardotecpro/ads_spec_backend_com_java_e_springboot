package com.company;

import com.company.entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product product =new Product();

        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        product.name = sc.nextLine();
        System.out.print("Price: ");
        product.price = sc.nextDouble();
        System.out.println("Quantity in stock: ");
        product.quantity = sc.nextInt();

        System.out.println(product.name + ", " + product.price + ", " + product.quantity);


        sc.close();

    }
}
