package org.example.Function;

import org.example.Services.ServicesImpl.CustomerServicesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FifoTest {

    private Fifo fifo;

    @BeforeEach
    void setUp() {
        fifo = new Fifo();
    }

    @Test
    void testEnqueueAndDequeue() {
        // Create a sample customer
        CustomerServicesImpl customer = new CustomerServicesImpl();

        // Enqueue the customer
        Fifo.enqueue(customer);

        // Dequeue the customer and check if it's the same customer
        CustomerServicesImpl dequeuedCustomer = Fifo.dequeue();

        assertNotNull(dequeuedCustomer);
        assertEquals(customer, dequeuedCustomer);
    }

    @Test
    void testIsEmpty() {
        // Initially, the Fifo should be empty
        assertTrue(fifo.isEmpty());

        // Enqueue a customer
        Fifo.enqueue(new CustomerServicesImpl());

        // Now, the Fifo should not be empty
        assertFalse(fifo.isEmpty());
    }
}