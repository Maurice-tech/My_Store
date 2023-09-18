package org.example.Services.ServicesImpl;

import org.example.StoreComponent.Customer;
import org.example.Services.CustomerServices;
import org.example.StoreComponent.Product;

import java.util.Comparator;

//, Comparator<CustomerServicesImpl>
public class CustomerServicesImpl implements CustomerServices, Comparator<CustomerServicesImpl>{


    Customer customer;

    public CustomerServicesImpl() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public CustomerServicesImpl(Customer customer) {
        this.customer = customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void addToCart(String item, int quantity) {

        try {
            // Check if the product exists in the product map
            if (!ManagerServicesImpl.getProductMap().containsKey(item)) {
                System.out.println("We don't sell " + item + " here.\n");
                return; // Exit early if the product doesn't exist
            }

            Product product = ManagerServicesImpl.getProductMap().get(item);
            int availableQuantity = product.getQuantity();

            // Check if there is enough quantity in stock
            if (availableQuantity >= quantity) {
                product.setQuantity(availableQuantity - quantity);
                System.out.println(item + " request made.\n");
                customer.getCart().put(item, quantity); // Add to the cart
            } else {
                System.out.println("Not enough " + item + " in stock.\n");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

//        String name = null;
//        if (ManagerServicesImpl.getProductMap().containsKey(name)) {
//
//            customer.getCart().put(name,quantity);
//            Product product = ManagerServicesImpl.getProductMap().get(name);
//            int availableQuantity = product.getQuantity();
//
//            if (availableQuantity >= quantity) {
//                product.setQuantity(availableQuantity - quantity);
//                System.out.println(name + " request made.\n");
//            } else {
//                System.out.println("Not enough " + name + " in stock.\n");
//            }
//        } else {
//            System.out.println("We don't sell " + name + " here.\n");
//        }



    @Override
    public void buyProduct() {

        System.out.println("This customer "+ "\""+ customer.getFullName()+"\""+" has placed an order");
    }
    @Override
    public int compare(CustomerServicesImpl customer1, CustomerServicesImpl customer2) {
        // Iterate over the keys in the first customer's cart
        for (String key : customer1.getCustomer().getCart().keySet()) {
            int quantity1 = customer1.getCustomer().getCart().get(key);
            int quantity2 = customer2.getCustomer().getCart().get(key);

            // Compare the quantities
            int quantityComparison = Integer.compare(quantity2, quantity1);

            if (quantityComparison != 0) {
                return quantityComparison; // Higher quantity comes first
            } else {
                // If quantities are the same, compare by total price
                double totalPrice1 = quantity1 * ManagerServicesImpl.getProductMap().get(key).getPrice();
                double totalPrice2 = quantity2 * ManagerServicesImpl.getProductMap().get(key).getPrice();
                int priceComparison = Double.compare(totalPrice2, totalPrice1);

                if (priceComparison != 0) {
                    return priceComparison; // Higher total price comes first
                }
            }
        }

        // If quantities and total prices are the same for all items, compare by customer name
        return customer1.getCustomer().getFullName().compareTo(customer2.getCustomer().getFullName());
    }

//    Customer getCustomer() {
//
//        return customer;
//    }

}
