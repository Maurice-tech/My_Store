package org.example.StoreComponent;

import org.example.StoreComponent.Enum.CATEGORY;

public class Product {
    private String productName;
    private int price;
    private int quantity;
    private CATEGORY categoryName;

    public Product(String productName, int price, int quantity, CATEGORY categoryName) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.categoryName = categoryName;

    }

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CATEGORY getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CATEGORY categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", categoryName=" + categoryName +
                '}';
    }

}
