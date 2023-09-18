package org.example.Services;

import org.example.Services.ServicesImpl.CustomerServicesImpl;

public interface CustomerServices {
    public void addToCart(String item, int quantity);
    public void buyProduct();

    int compare(CustomerServicesImpl customer1, CustomerServicesImpl customer2);
}
