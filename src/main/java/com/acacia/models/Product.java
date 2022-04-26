package com.acacia.models;

public class Product {
      
    public int productId ;
    public String productName;
    public double productPrice;

    public Product(int inId, String inName, double inPrice) {
        this.productId = inId;
        this.productName = inName;
        this.productPrice = inPrice;
    }

}
