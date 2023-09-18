package org.example.Services.ServicesImpl;

import org.example.Function.Fifo;
import org.example.Function.Priority;
import org.example.StoreComponent.Cashier;
import org.example.Services.CashierServices;
import org.example.StoreComponent.Customer;
import org.example.StoreComponent.Enum.ROLES;
import org.example.StoreComponent.Product;
import org.example.StoreComponent.Staff;

import java.util.Map;

public class CashierServicesImpl implements CashierServices {
    Customer customer;




//    public boolean dispensesReceipts(Cashier cashier) {
//        CustomerServicesImpl customer = Fifo.dequeue();
//        if (customer == null || customer.getCustomer() == null) {
//            System.out.println("No customer in the Fifo queue or the customer is null");
//            return false;
//        }
//
//        System.out.println("=========================================================================");
//        System.out.println("=========================================================================");
//        System.out.println("Receipt for : " + customer.getCustomer().getFullName() + "           " + customer.getCustomer().getPhoneNumber());
//
//        double totalCost = customer.getCustomer().getCart().entrySet().stream()
//                .mapToDouble(entry -> {
//                    String productKey = entry.getKey();
//                    int quantity = entry.getValue();
//                    double price = ManagerServicesImpl.getProductMap().get(productKey).getPrice();
//                    System.out.println(productKey + "...................Price : " + price + "....................Quantity: " + quantity);
//                    return price * quantity;
//                })
//                .sum();
//
//        System.out.println("Total Quantity : " + customer.getCustomer().getCart().values().stream().mapToInt(Integer::intValue).sum());
//        System.out.println("Total Amount : " + totalCost);
//
//        if (totalCost > customer.getCustomer().getWallet()) {
//            System.out.println("Insufficient funds! Please recharge your wallet.");
//            return false;
//        }
//
//        System.out.println("Your Balance : " + (customer.getCustomer().getWallet() - totalCost));
//        String issuedBy = (cashier != null && ROLES.CASHIER.equals(cashier.getRole())) ?
//                cashier.getFullName() + "........Cashier id No: " + cashier.getStaffId() :
//                "Unknown (Not a cashier)";
//
//        System.out.println("Issued by : " + issuedBy);
//        System.out.println("========================================================================");
//        System.out.println("========================================================================");
//
//        return true;
//    }

    @Override

    public boolean dispensesReceipts(Cashier cashier) {

//        public boolean dispensesReceipts(Cashier cashier) {
            CustomerServicesImpl customer = Fifo.dequeue();
            if (customer == null || customer.getCustomer() == null) {
                // Handle the case where there is no customer in the Fifo queue or the customer is null
                return false;
            }

            Customer customerData = customer.getCustomer();

            double totalCost = customerData.cart.entrySet()
                    .stream()
                    .mapToDouble(entry -> {
                        String productName = entry.getKey();
                        int quantity = entry.getValue();
                        double price = ManagerServicesImpl.getProductMap().getOrDefault(productName, new Product()).getPrice();
                        return price * quantity;
                    })
                    .sum();

            int totalQuantity = customerData.cart.values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();

            System.out.println("=========================================================================");
            System.out.println("=========================================================================");
            System.out.println("Receipt for : " + customerData.getFullName() + "           " + customerData.getPhoneNumber());

            customerData.cart.entrySet()
                    .forEach(entry -> {
                        String productName = entry.getKey();
                        int quantity = entry.getValue();
                        double price = ManagerServicesImpl.getProductMap().getOrDefault(productName, new Product()).getPrice();

                        System.out.println(productName + "...................Price : " + price);
                    });

            System.out.println("Total Quantity : " + totalQuantity);
            System.out.println("Total Amount : " + totalCost);

            if (totalCost > customerData.getWallet()) {
                System.out.println("Insufficient funds! Please recharge your wallet.");
                return false;
            }

            System.out.println("Your Balance : " + (customerData.getWallet() - totalCost));

            System.out.println("Issued by : " + (cashier != null && ROLES.CASHIER.equals(cashier.getRole()) ?
                    cashier.getFullName() + "........Cashier id No: " + cashier.getStaffId() :
                    "Unknown (Not a cashier)"));

            System.out.println("Thank for patronizing our store, see you next time.");
            System.out.println("========================================================================");
            System.out.println("========================================================================");

            return true;
        }






//        CustomerServicesImpl customer = Fifo.dequeue();
//        if (customer == null || customer.getCustomer() == null) {
//            // Handle the case where there is no customer in the Fifo queue or the customer is null
//            return false;
//        }
//        double totalCost = 0;
//        int totalQuantity = 0; // Initialize totalQuantity to 0
//
//        System.out.println("=========================================================================");
//        System.out.println("=========================================================================");
//        System.out.println("Receipt for : " + customer.getCustomer().getFullName() + "           " + customer.getCustomer().getPhoneNumber());
//
//        for (String key : customer.getCustomer().cart.keySet()) {
//            int quantity = customer.getCustomer().getCart().get(key); // Get the quantity of the product
//            totalQuantity += quantity; // Add to the total quantity
//
//            double price = ManagerServicesImpl.getProductMap().get(key).getPrice(); // Get the price of the product
//
//            totalCost += price * quantity;
//            System.out.println(key + "...................Price : " + totalCost );
//            // Calculate the cost for the product
//            System.out.println("Total Quantity : " + totalQuantity); // Print the total quantity
//            System.out.println("Total Amount : " + totalCost);
//
//        }
//
//        System.out.println("Total Quantity : " + totalQuantity); // Print the total quantity
//        System.out.println("Total Amount : " + totalCost);
//
//        // Check if the total cost exceeds the customer's wallet
//        if (totalCost > customer.getCustomer().getWallet()) {
//            System.out.println("Insufficient funds! Please recharge your wallet.");
//            return false; // Return false to indicate insufficient funds
//        }
//
//        System.out.println("Your Balance : " + (customer.getCustomer().getWallet() - totalCost));
//        if (cashier != null && ROLES.CASHIER.equals(cashier.getRole())) {
//            System.out.println("Issued by : " + cashier.getFullName() + "........Cashier id No: " + cashier.getStaffId());
//            System.out.println("Thank for patronizing our store, see you next time.");
//        } else {
//            System.out.println("Issued by : Unknown (Not a cashier)");
//        }
//        System.out.println("========================================================================");
//        System.out.println("========================================================================");
//
//        return true; // Return true to indicate a successful transaction
//    }


    @Override

    public boolean dispensesReceipts2(Cashier cashier) {
        CustomerServicesImpl customer = Priority.dequeue();
        if (customer == null || customer.getCustomer() == null) {
            System.out.println("No customer in the Priority queue or the customer is null");
            return false;
        }

        System.out.println("=========================================================================");
        System.out.println("=========================================================================");
        System.out.println("Receipt for : " + customer.getCustomer().getFullName() + "           " + customer.getCustomer().getPhoneNumber());

        double totalCost = customer.getCustomer().getCart().entrySet().stream()
                .mapToDouble(entry -> {
                    String productKey = entry.getKey();
                    int quantity = entry.getValue();
                    double price = ManagerServicesImpl.getProductMap().get(productKey).getPrice();
                    System.out.println(productKey + "...................Price : " + price + "....................Quantity: " + quantity);
                    return price * quantity;
                })
                .sum();

        System.out.println("Total Amount : " + totalCost);

        if (totalCost > customer.getCustomer().getWallet()) {
            System.out.println("Insufficient funds! Please recharge your wallet.");
            return false;
        }

        System.out.println("Your Balance : " + (customer.getCustomer().getWallet() - totalCost));
        String issuedBy = (cashier != null && ROLES.CASHIER.equals(cashier.getRole())) ?
                cashier.getFullName() + "........Cashier id No: " + cashier.getStaffId() :
                "Unknown (Not a cashier)";

        System.out.println("Issued by : " + issuedBy);
        System.out.println("========================================================================");
        System.out.println("========================================================================");

        return true;
    }
}




//    public boolean dispensesReceipts2(Cashier cashier) {
//        CustomerServicesImpl customer = Priority.dequeue();
//        if (customer == null || customer.getCustomer() == null) {
//            // Handle the case where there is no customer in the Priority queue or the customer is null
//            return false;
//        }
//        double totalCost = 0;
//        System.out.println("=========================================================================");
//        System.out.println("=========================================================================");
//        System.out.println("Receipt for : " + customer.getCustomer().getFullName() + "           " + customer.getCustomer().getPhoneNumber());
//        for (String key : customer.getCustomer().cart.keySet()) {
//            System.out.println(key + "...................Price : " + ManagerServicesImpl.getProductMap().get(key).getPrice() + "....................Quantity: " + customer.getCustomer().getCart().get(key));
//            totalCost += ManagerServicesImpl.getProductMap().get(key).getPrice() * customer.getCustomer().getCart().get(key);
//        }
//        System.out.println("Total Amount : " + totalCost);
//
//        // Check if the total cost exceeds the customer's wallet
//        if (totalCost > customer.getCustomer().getWallet()) {
//            System.out.println("Insufficient funds! Please recharge your wallet.");
//            return false; // Return false to indicate insufficient funds
//        }
//
//        System.out.println("Your Balance : " + (customer.getCustomer().getWallet() - totalCost));
//        if (cashier != null && ROLES.CASHIER.equals(cashier.getRole())) {
//            System.out.println("Issued by : " + cashier.getFullName() + "........Cashier id No: " + cashier.getStaffId());
//            System.out.println("Thank for patronizing our store, see you next time.");
//        } else {
//            System.out.println("Issued by : Unknown (Not a cashier)");
//        }
//        System.out.println("========================================================================");
//        System.out.println("========================================================================");
//        return true; // Return true to indicate successful transaction completed
//    }
//}


//        CustomerServicesImpl customer = Fifo.dequeue();
//        if (customer == null || customer.getCustomer() == null) {
//            // Handle the case where there is no customer in the Fifo queue or the customer is null
//            return false;
//        }
//        double totalCost = 0;
//        System.out.println("=========================================================================");
//        System.out.println("=========================================================================");
//        System.out.println("Receipt for : " + customer.getCustomer().getFullName() + "           " + customer.getCustomer().getPhoneNumber());
//        for (String key : customer.getCustomer().cart.keySet()) {
//            System.out.println(key + "...................Price : " + ManagerServicesImpl.getProductMap().get(key).getPrice() + "....................Quantity: " + customer.getCustomer().getCart().get(key));
//            totalCost += ManagerServicesImpl.getProductMap().get(key).getPrice() * customer.getCustomer().getCart().get(key);
//        }
//        System.out.println("Total Amount : " + totalCost);
//
//        // Check if the total cost exceeds the customer's wallet
//        if (totalCost > customer.getCustomer().getWallet()) {
//            System.out.println("Insufficient funds! Please recharge your wallet.");
//            return false; // Return false to indicate insufficient funds
//        }
//
//        System.out.println("Your Balance : " + (customer.getCustomer().getWallet() - totalCost));
//        if (cashier != null && ROLES.CASHIER.equals(cashier.getRole())) {
//            System.out.println("Issued by : " + cashier.getFullName() + "........Cashier id No: " + cashier.getStaffId());
//            System.out.println("Thank for patronizing our store, see you next time.");
//        } else {
//            System.out.println("Issued by : Unknown (Not a cashier)");
//        }
//        System.out.println("========================================================================");
//        System.out.println("========================================================================");
//
//        return true; // Return true to indicate successful transaction
//    }

