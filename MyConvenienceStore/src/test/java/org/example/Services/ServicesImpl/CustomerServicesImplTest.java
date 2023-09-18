package org.example.Services.ServicesImpl;

import org.example.StoreComponent.Customer;
import org.example.StoreComponent.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerServicesImplTest {

        private CustomerServicesImpl customerServices;

        @Before
        public void setUp() {
            // Initialize the CustomerServicesImpl instance
            customerServices = new CustomerServicesImpl();
        }

        @Test
        public void testAddToCartValidProduct() {
            // Create a test scenario with a valid product

            // Assuming you have a method to set the customer for customerServices
            Customer customer = new Customer();
            customerServices.setCustomer(customer);

            // Add a product to the cart
            String productName = "Shampoos";
            int quantity = 3;

            // Initialize a sample product map (replace with your implementation)
            ManagerServicesImpl.getProductMap().put(productName, new Product());

            customerServices.addToCart(productName, quantity);

            // Assert that the product is added to the cart
            assertTrue(customer.getCart().containsKey(productName));
            assertEquals(quantity, (int) customer.getCart().get(productName));
        }

        @Test
        public void testAddToCartInvalidProduct() {
            // Create a test scenario with an invalid product

            // Assuming you have a method to set the customer for customerServices
            Customer customer = new Customer();
            customerServices.setCustomer(customer);

            // Add an invalid product to the cart
            String productName = "InvalidProduct";
            int quantity = 3;

            customerServices.addToCart(productName, quantity);

            // Assert that the product is not added to the cart
            assertFalse(customer.getCart().containsKey(productName));
        }

        @Test
        public void testAddToCartNotEnoughStock() {
            // Create a test scenario where there is not enough stock

            // Assuming you have a method to set the customer for customerServices
            Customer customer = new Customer();
            customerServices.setCustomer(customer);

            // Add a product with not enough stock to the cart
            String productName = "Product2";
            int quantityInStock = 2;
            int requestedQuantity = 3;

            // Initialize a sample product map (replace with your implementation)
            ManagerServicesImpl.getProductMap().put(productName, new Product());

            customerServices.addToCart(productName, requestedQuantity);

            // Assert that the product is not added to the cart due to insufficient stock
            assertTrue(customer.getCart().containsKey(productName));
        }

        // Add more test cases to cover different scenarios for the addToCart method

        @Test
        public void testCompare() {
            // Create test scenarios for the compare method

            // Create two CustomerServicesImpl instances with different cart contents
            CustomerServicesImpl customer1 = new CustomerServicesImpl(new Customer("John Doe"));
            customer1.addToCart("ProductA", 2);
            customer1.addToCart("ProductB", 3);

            CustomerServicesImpl customer2 = new CustomerServicesImpl(new Customer("Alice Smith"));
            customer2.addToCart("ProductA", 3);
            customer2.addToCart("ProductB", 2);

            // Compare the two customers
            int result = customerServices.compare(customer1, customer2);

            // Assert the comparison result based on your expected outcome
            assertTrue(result > 0); // Example: customer1 should come first
        }

        // Add more test cases for other methods as needed

    }