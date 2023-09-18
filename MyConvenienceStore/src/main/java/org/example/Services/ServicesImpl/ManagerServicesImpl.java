package org.example.Services.ServicesImpl;

import org.example.StoreComponent.*;
import org.example.StoreComponent.Enum.CATEGORY;
import org.example.Services.ManagerServices;
import org.example.StoreComponent.Enum.QUALIFICATION;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ManagerServicesImpl implements ManagerServices {
    public static Map<String, Cashier> cashiers = new TreeMap<>();
    private static Map<String, Product> productMap = new HashMap<>();
    private static  Map<String, Product> totalProducts = new HashMap<>();

    public static Map<String, Product> getTotalProducts() {
        return totalProducts;
    }

    private static void addCashiers(String name, Cashier cashier) {
        cashiers.put(name, cashier);
    }

    public static void addProducts(String name, Product product) {
        productMap.put(name, product);
    }

    public static Map<String, Product> getProductMap() {
        return productMap;
    }

    public static boolean getCashier() {
        return true;
    }

//    public static Map<String, Product> getTotalProducts() {
//        return totalProducts;

    @Override
    public String hireCashierApplicant(Staff staff, CashierApplicant cashierApplicant) {
        try {
            if (staff.getRole() != null &&
                    (cashierApplicant.getQualification() == QUALIFICATION.BSC || cashierApplicant.getQualification() == QUALIFICATION.HND) &&
                    cashierApplicant.getAge() >= 20 && cashierApplicant.getAge() <= 60) {

                cashiers.put(cashierApplicant.getApplicantName(), new Cashier());
                String message = cashierApplicant.getApplicantName() + " You are hired as the new cashier";
                System.out.println(message);
                return message;
            } else {
                throw new CashierApplicantNotQualifiedException(cashierApplicant.getApplicantName() + " You are not qualified");
            }
        } catch (CashierApplicantNotQualifiedException ex) {
            System.out.println(ex.getMessage());
            return ex.getMessage();
        }
    }
//    public String hireCashierApplicant(Staff staff, CashierApplicant cashierApplicant) {
//        if (staff.getRole() != null) {
//            if (((cashierApplicant.getQualification() == (QUALIFICATION.BSC)) || (cashierApplicant.getQualification() == (QUALIFICATION.HND)) && (cashierApplicant.getAge() >= 20 && cashierApplicant.getAge() <= 60))) {
//                cashiers.put(cashierApplicant.getApplicantName(), new Cashier());
//                System.out.println(cashierApplicant.getApplicantName()+" " + "You are hired as the new cashier");
//                return (cashierApplicant.getApplicantName() + " " + "You are hired as the new cashier");
//            } else {
//                System.out.println(cashierApplicant.getApplicantName()+" " + "You are not qualified");
//            }
//        }return (cashierApplicant.getApplicantName() + " " + "You are not qualified");
//
//    }
//


    @Override

    public boolean sackCashier(String name) {
        // Convert the provided name to lowercase for case-insensitive comparison
        String lowerCaseName = name.toLowerCase();

        // Use Java 8 Stream API to simplify the process
        Optional<String> matchedCashierName = cashiers.keySet().stream()
                .filter(key -> key.toLowerCase().equals(lowerCaseName))
                .findFirst();

        if (matchedCashierName.isPresent()) {
            String cashierName = matchedCashierName.get();
            Cashier cashier = cashiers.get(cashierName);
            cashier.addStrike();
            System.out.println(cashierName + " you have been given a strike: " + cashier.getStrike() + " strikes");

            if (cashier.getStrike() >= 3) {
                cashiers.remove(cashierName);
                System.out.println(cashierName + " Your cashier has been sacked due to the number of strikes exceeding 3.");
            }
            return true;
        } else {
            System.out.println("Name not on our list or map");
            return false;
        }
    }

//    public boolean sackCashier(String name) {
//        // Convert the provided name to lowercase for case-insensitive comparison
//        String lowerCaseName = name.toLowerCase();
//        // Iterate through the keys of the cashiers map
//        for (String key : cashiers.keySet()) {
//            // Check if the lowercase key matches the provided lowercase name
//            if (key.toLowerCase().equals(lowerCaseName)) {
//                // Get the cashier using the matching key
//                Cashier cashier = cashiers.get(key);
//                // Increment the strike count for the cashier
//                cashier.addStrike();
//                System.out.println(key + " you have been given a strike: " + cashier.getStrike() + " strikes");
//                // Check if the cashier has reached the maximum allowed strikes
//                if (cashier.getStrike() >= 3) {
//                    // Remove the cashier from the map
//                    cashiers.remove(key);
//                    System.out.println(key + " Your cashier has been sacked due to the number of strikes exceeding 3.");
//                }
//                return true;
//            }
//        }
//        // If no match is found, the name is not in the map
//        System.out.println("Name not on our list or map");
//        return false;
//    }

    @Override
    public void addProduct(String productName, int price, int quantity, CATEGORY categoryName) {
        Product newProduct = new Product(productName, price, quantity, categoryName);
        productMap.put(productName, newProduct);
        System.out.println("This product " + "\"" + productName + "\"" + " has been added to the product list");
    }


    @Override
    public void removeProduct(String name) {
        // Use Java 8 Stream API to simplify the process
        Optional<String> matchedProductName = productMap.keySet().stream()
                .filter(key -> key.equalsIgnoreCase(name))
                .findFirst();

        if (matchedProductName.isPresent()) {
            String productName = matchedProductName.get();
            productMap.remove(productName);
            System.out.println(productName + " has been removed from our product list");
        } else {
            System.out.println("Product not found in our product list");
        }
    }
}

//    public void removeProduct(String name) {
//        Product productBought = null;
//        for (String key : productMap.keySet()) {
//            if (key.equalsIgnoreCase(name)) {
//                productBought = productMap.get(key);
//                break;
//            }
//        }
//        if (productBought != null) {
//            productMap.remove(productBought.getProductName());
//            productMap.remove(name);
//            System.out.println(name + " Has been removed from our product list");
//        } else
//            System.out.println("Product not found in our product list");
//
//    }
//}



