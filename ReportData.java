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
 * 
 */




public class ReportData {
    public static int index = 0; // keeps count of products

    // product details
    private String code;
    private String name;
    private int category;
    private String categoryName;
    private String warranty;
    private double price;
    private int stock;
    private String supplier;

    // creates a new product
    public ReportData(String code, String name, int category, String categoryName, String warranty, double price, int stock, String supplier){
        this.code=code;
        this.name=name;
        this.category=category;
        this.categoryName=categoryName;
        this.warranty=warranty;
        this.price=price;
        this.stock=stock;
        this.supplier=supplier;
    }

    // get methods to read
    public String getCode(){return code;}
    public String getName(){return name;}
    public int getCategory(){return category;}
    public String getCategoryName(){return categoryName;}
    public String getWarranty(){return warranty;}
    public double getPrice(){return price;}
    public int getStock(){return stock;}
    public String getSupplier(){return supplier;}

    //methods to change
    public void setCode(String c){code=c;}
    public void setName(String n){name=n;}
    public void setCategory(int c){category=c;}
    public void setCategoryName(String c){categoryName=c;}
    public void setWarranty(String w){warranty=w;}
    public void setPrice(double p){price=p;}
    public void setStock(int s){stock=s;}
    public void setSupplier(String s){supplier=s;}
}