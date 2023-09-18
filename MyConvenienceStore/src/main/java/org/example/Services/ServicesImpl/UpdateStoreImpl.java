package org.example.Services.ServicesImpl;

import org.example.StoreComponent.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateStoreImpl {
    public void synchronizeStock() {
        var path = "src/main/resources/Product.csv";


        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path)))) {
            pw.println("Name,Price,Quantity,Category");
            for (Product product : ManagerServicesImpl.getProductMap().values()) {
                String name = product.getProductName();
                String price = String.valueOf(product.getPrice());
                String quantity = String.valueOf(product.getQuantity());
                String category = extractCategoryName(String.valueOf(product.getCategoryName()));

                String line = name + "," + price + "," + quantity + ","  + category;
                pw.println(line);
            }
            System.out.println("Stock synchronized successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private String extractCategoryName(String categoryWithInfo) {
        // Extract the actual category name from the string
        String[] parts = categoryWithInfo.split("=");
        if (parts.length > 1) {
            String categoryName = parts[1].trim();
            // Remove any trailing characters that are not part of the category name
            return categoryName.replaceAll("[^a-zA-Z_ ]", "");
        }
        return categoryWithInfo;
    }

}


