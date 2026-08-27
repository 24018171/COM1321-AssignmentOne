/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author Maoko Tshepo 
 * 24018171
 * com1321 assignment1
 */


import java.util.Scanner;

public class Products {
    static Scanner scanner = new Scanner(System.in); // for reading input
    static ReportData[] storeItems = new ReportData[100]; // stores products

    // shows menu
    public static int DisplayMenu(){
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new product.");
        System.out.println("(2) Search for a product.");
        System.out.println("(3) Update a product.");
        System.out.println("(4) Delete a product.");
        System.out.println("(5) Print report.");
        System.out.println("(6) Exit Application.");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // clear enter
        return choice;
    }

    // adds a new product
    public static void CaptureProduct(){
        System.out.println("CAPTURE A NEW PRODUCT");
        System.out.println("***************************");
        System.out.print("Enter the product code: ");
        String code = scanner.nextLine();
        System.out.print("Enter the product name: ");
        String name = scanner.nextLine();

        int category = 0;
        String categoryName = "";
        // keep asking until correct category
        while(true){
            System.out.println("Select the product category:");
            System.out.println("Desktop Computer - 1");
            System.out.println("Laptop - 2");
            System.out.println("Tablet - 3");
            System.out.println("Printer - 4");
            System.out.println("Gaming Console - 5");
            System.out.print("Enter category: ");
            category = scanner.nextInt();
            scanner.nextLine();
            if(category==1){categoryName="Desktop Computer"; break;}
            else if(category==2){categoryName="Laptop"; break;}
            else if(category==3){categoryName="Tablet"; break;}
            else if(category==4){categoryName="Printer"; break;}
            else if(category==5){categoryName="Gaming Console"; break;}
            else{System.out.println("Invalid category! Please re-enter valid product category (1-5).");}
        }

        // warranty 
        System.out.println("PRODUCT CATEGORY >> " + category);
        System.out.print("Indicate the product warranty. Enter (1) for 6 months or any other key for 2 years: ");
        String wInput = scanner.nextLine();
        String warranty = wInput.equals("1")? "6 months" : "2 years";

        System.out.print("Enter the price for " + name + ": R");
        double price = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Enter the stock level for " + name + ": ");
        int stock = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter the supplier for " + name + ": ");
        String supplier = scanner.nextLine();

        // make new product and save it
        ReportData data = new ReportData(code, name, category, categoryName, warranty, price, stock, supplier);
        SaveProduct(data);
    }

    // saves product to array
    public static void SaveProduct(ReportData product){
        storeItems[ReportData.index] = product; 
        ReportData.index++;
        System.out.println("Product details has been saved successfully!!!");
    }

    // finds a product by code
    public static void SearchProduct(){
        System.out.print("Please enter the product code to search: ");
        String code = scanner.nextLine();
        for(int i=0;i<ReportData.index;i++){
            if(storeItems[i].getCode().equalsIgnoreCase(code)){ // found our product here
                System.out.println("------------------------------------------------");
                System.out.println("PRODUCT SEARCH RESULTS");
                System.out.println("------------------------------------------------");
                System.out.println("PRODUCT CODE >> " + storeItems[i].getCode());
                System.out.println("PRODUCT NAME >> " + storeItems[i].getName());
                System.out.println("PRODUCT CATEGORY >> " + storeItems[i].getCategoryName());
                System.out.println("PRODUCT WARRANTY >> " + storeItems[i].getWarranty());
                System.out.println("PRODUCT PRICE >> R" + storeItems[i].getPrice());
                System.out.println("PRODUCT STOCK LEVEL >> " + storeItems[i].getStock());
                System.out.println("PRODUCT SUPPLIER >> " + storeItems[i].getSupplier());
                System.out.println("------------------------------------------------");
                return;
            }
        }
        System.out.println("The product cannot be located. Invalid Product"); // means we cant find any of products
    }

    // removes a product
    public static void DeleteProduct(){
        System.out.print("Please enter the product code to delete: ");
        String code = scanner.nextLine();
        for(int i=0;i<ReportData.index;i++){
            if(storeItems[i].getCode().equalsIgnoreCase(code)){
                System.out.print("Are you sure you want to delete " + code + "? (y/n): ");
                String confirm = scanner.nextLine();
                if(confirm.equalsIgnoreCase("y")){
                    for(int j=i;j<ReportData.index-1;j++) storeItems[j]=storeItems[j+1]; // move items left
                    storeItems[ReportData.index-1]=null; // clear the last
                    ReportData.index--; // reduce the counting
                    System.out.println("Product deleted successfully!");
                } else {
                    System.out.println("Delete cancelled.");
                }
                return;
            }
        }
        System.out.println("Product not found.");
    }

    // changes product details
    public static void UpdateProduct(){
        System.out.print("Please enter the product code to update: ");
        String code = scanner.nextLine();
        for(int i=0;i<ReportData.index;i++){
            if(storeItems[i].getCode().equalsIgnoreCase(code)){
                System.out.print("Update the warranty? (y) Yes, (n) No: ");
                String uw = scanner.nextLine();
                if(uw.equalsIgnoreCase("y")){
                    System.out.print("Indicate warranty (1 for 6 months or any key for 2 years): ");
                    String wIn = scanner.nextLine();
                    String newW = wIn.equals("1")? "6 months" : "2 years";
                    storeItems[i].setWarranty(newW);
                }
                System.out.print("Update the product price? (y) Yes, (n) No: ");
                String up = scanner.nextLine();
                if(up.equalsIgnoreCase("y")){
                    System.out.print("Enter the new price for " + storeItems[i].getName() + " >> ");
                    double np = scanner.nextDouble(); scanner.nextLine();
                    storeItems[i].setPrice(np);
                }
                System.out.print("Update the stock level? (y) Yes, (n) No: ");
                String us = scanner.nextLine();
                if(us.equalsIgnoreCase("y")){
                    System.out.print("Enter new stock: ");
                    int ns = scanner.nextInt(); scanner.nextLine();
                    storeItems[i].setStock(ns);
                }
                System.out.println("Product details has been updated successfully!!!");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    // shows all products
    public static void PrintReport(){
        System.out.println("PRODUCT REPORT");
        System.out.println("==============================================");
        if(ReportData.index==0){System.out.println("No products captured."); return;}
        double totalValue=0;
        for(int i=0;i<ReportData.index;i++){
            System.out.println("PRODUCT " + (i+1));
            System.out.println("------------------------------------------------");
            System.out.println("PRODUCT CODE >> " + storeItems[i].getCode());
            System.out.println("PRODUCT NAME >> " + storeItems[i].getName());
            System.out.println("PRODUCT CATEGORY >> " + storeItems[i].getCategoryName());
            System.out.println("PRODUCT WARRANTY >> " + storeItems[i].getWarranty());
            System.out.println("PRODUCT PRICE >> R" + storeItems[i].getPrice());
            System.out.println("PRODUCT LEVEL >> " + storeItems[i].getStock());
            System.out.println("PRODUCT SUPPLIER >> " + storeItems[i].getSupplier());
            System.out.println("------------------------------------------------");
            totalValue += storeItems[i].getPrice() * storeItems[i].getStock(); // add up
        }
        double avg = totalValue / ReportData.index; // average
        System.out.println("TOTAL PRODUCT COUNT: " + ReportData.index);
        System.out.println("TOTAL PRODUCT VALUE: R" + totalValue);
        System.out.println("AVERAGE PRODUCT VALUE: R" + avg);
    }

    // closes app
    public static void ExitApplication(){
        System.out.println("Exiting...");
        System.exit(0);
    }
}