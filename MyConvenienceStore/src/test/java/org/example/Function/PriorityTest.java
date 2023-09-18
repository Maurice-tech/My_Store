package org.example.Function;

import org.example.Services.ServicesImpl.CustomerServicesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PriorityTest {

    private Priority priority;

    @BeforeEach
    void setUp() {
        priority = new Priority();
    }

    @org.junit.jupiter.api.Test
    void testEnqueueAndDequeue() {
        // Create a sample customer
        CustomerServicesImpl customer = new CustomerServicesImpl();

        // Enqueue the customer
        Priority.enqueue(customer);

        // Dequeue the customer and check if it's the same customer
       CustomerServicesImpl dequeuedCustomer = Priority.dequeue();

        assertNotNull(dequeuedCustomer);
        assertEquals(customer, dequeuedCustomer);
    }

    @Test
    void testIsEmpty() {
        // Initially, the Priority queue should be empty
        assertTrue(priority.isEmpty());

        // Enqueue a customer
        Priority.enqueue(new CustomerServicesImpl());

        // Now, the Priority queue should not be empty
        assertFalse(priority.isEmpty());
    }
}