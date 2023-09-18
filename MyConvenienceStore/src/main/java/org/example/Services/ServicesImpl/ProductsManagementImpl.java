package org.example.Services.ServicesImpl;

import org.example.StoreComponent.Enum.CATEGORY;
import org.example.StoreComponent.Product;
import org.example.Services.ProductsManagement;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductsManagementImpl implements ProductsManagement {

    private static Map<String, Product> non_Alcoholic_drinks = new HashMap<>();
    private static Map<String, Product> alcoholic_drinks = new HashMap<>();
    private static Map<String, Product> cosmetics = new HashMap<>();
    private static Map<String, Product> beverages = new HashMap<>();
    private static Map<String, Product> bakeries = new HashMap<>();


    @Override
    public boolean addProductsToStore() {
        String filePath = "src/main/resources/Product.csv";
        String line;

        try (BufferedReader input = new BufferedReader(new FileReader(filePath))) {
            while ((line = input.readLine()) != null) {
                String[] row = line.split(",");
                if (!row[0].equalsIgnoreCase("name")) {
                    Product product = createProductFromRow(row);
                    if (product != null) {
                        ManagerServicesImpl.getProductMap().put(row[0], product);
                        ManagerServicesImpl.addProducts(row[0], product);
                    } else {
                        System.out.println("Failed to create product from row: " + Arrays.toString(row));
                    }
                }
            }
            System.out.println("Number of products loaded: " + ManagerServicesImpl.getProductMap().size());
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        } catch (IOException e) {
            System.out.println("Error occurred: " + e);
        }
        return false;
    }

    private Product createProductFromRow(String[] row) {
        if (row.length >= 4) {
            String name = row[0];
            int price = Integer.parseInt(row[1]);
            int quantity = Integer.parseInt(row[2]);
            String category = row[3];

            return switch (category.toLowerCase()) {
                case "alcoholic_drinks" -> new Product(name, price, quantity, CATEGORY.ALCOHOLIC_DRINKS);
                case "non_alcoholic_drinks" -> new Product(name, price, quantity, CATEGORY.NON_ALCOHOLIC_DRINKS);
                case "cosmetics" -> new Product(name, price, quantity, CATEGORY.COSMETICS);
                case "beverages" -> new Product(name, price, quantity, CATEGORY.BEVERAGES);
                case "bakeries" -> new Product(name, price, quantity, CATEGORY.BAKERIES);
                default -> null; // Unknown category, ignore the product
            };
        }
        return null; // Invalid row, ignore the product

    }


    public void viewItems(Map<String, Product> productMap) {
        System.out.println("Name" + "       " + "Price" + "      " + "Quantity " + "Category");

        productMap.values().stream()
                .forEach(product -> {
                    System.out.printf("%-12s %-12s %-12s %-12s",
                            product.getProductName(), product.getPrice(), product.getQuantity(), product.getCategoryName());
                    System.out.println();
                });
    }
//    public void viewItems(Map<String, Product> productMap) {
//        System.out.println("Name" + "       " + "Price" + "      " + "Quantity " + "Category");
//        for (var entry : productMap.entrySet()) {
//            Product product = entry.getValue();
//            System.out.printf("%-12s %-12s %-12s %-12s",
//                    product.getProductName(), product.getPrice(), product.getQuantity(), product.getCategoryName());
//            System.out.println();
//            }
//    }


    public static void writeProductsToCSV(Map<String, Product> productMap, String filePath) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            pw.println("Name,Price,Quantity,Category");

            productMap.values().forEach(product -> {
                String line = String.format("%s,%d,%d,%s",
                        product.getProductName(), product.getPrice(), product.getQuantity(),
                        product.getCategoryName().toString());
                pw.println(line);
            });

            System.out.println("Products added to CSV successfully!");
        } catch (IOException e) {
            System.out.println("Error adding products to CSV: " + e);
        }
    }
}


//    public static void writeProductsToCSV(Map<String, Product> productMap, String filePath) {
//        try (PrintWriter pw = new PrintWriter(new FileWriter("src/main/resources/Product.csv"))) {
//            pw.println("Name,Price,Quantity,Category");
//
//            for (Product product : productMap.values()) {
//                String line = String.format("%s,%d,%d,%s,",
//                        product.getProductName(), product.getPrice(), product.getQuantity(),
//                        product.getCategoryName().toString());
//                pw.println(line);
//            }
//
//            System.out.println("Products added to CSV successfully!");
//        } catch (IOException e) {
//            System.out.println("Error adding products to CSV: " + e);
//        }
//    }
//}
