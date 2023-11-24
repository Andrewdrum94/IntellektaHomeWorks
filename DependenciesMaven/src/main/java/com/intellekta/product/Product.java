package com.intellekta.product;

public class Product {

    private String productName;
    private double productPrice;
    private int productCount;

    public Product(String productName, double productPrice, int productCount) {
        this.productName = productName != null && !productName.trim().isEmpty() ? productName : "Unnamed";
        this.productPrice = productPrice >= 0 ? productPrice : 0;
        this.productCount = Math.max(productCount, 0);
    }

    public boolean productAvailable() {
        return this.productCount > 0;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        if(productPrice >= 0)
            this.productPrice = productPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = Math.max(productCount, 0);
    }
}
