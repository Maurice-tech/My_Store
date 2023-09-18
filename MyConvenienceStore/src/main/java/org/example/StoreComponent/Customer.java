package org.example.StoreComponent;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private static int count = 0;
    public Map<String,Integer> cart;
    private String fullName;
    private int id;
    private String phoneNumber;
    private double wallet;
    private int quantity;

    public Customer() {
    }

    public Customer(String fullName, int id, String phoneNumber, double wallet) {
        this.fullName = fullName;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.wallet = wallet;
        cart = new HashMap<>();
    }

    public Customer(String aliceSmith) {
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Customer.count = count;
    }

    public Map<String, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<String, Integer> cart) {
        this.cart = cart;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


//    public int compareTo(Customer other) {
//        return -Integer.compare(this.getCartQuantity(), other.getCartQuantity());
//    }
//
//    private int getCartQuantity() {
//        return totalQuantity;
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "cart=" + cart +
                ", fullName='" + fullName + '\'' +
                ", id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", wallet=" + wallet +
                ", quantity=" + quantity +
                '}';
    }


}
