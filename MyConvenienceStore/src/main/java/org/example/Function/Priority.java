package org.example.Function;

import org.example.Services.ServicesImpl.CustomerServicesImpl;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Priority {
    private static PriorityQueue<CustomerServicesImpl> customerPriorityQueue = new PriorityQueue<>(new Comparator<CustomerServicesImpl>() {

        @Override
        public int compare(CustomerServicesImpl customer1,CustomerServicesImpl customer2) {
            return 0;
        }
    });
    public static void enqueue(CustomerServicesImpl customer) {
        customerPriorityQueue.offer(customer);
    }
    public static CustomerServicesImpl dequeue() {
        return customerPriorityQueue.poll();
    }

    public static boolean getCustomerPriorityQueue() {
        return true;
    }

    public static void setCustomerPriorityQueue(PriorityQueue<CustomerServicesImpl> customerPriorityQueue) {
        Priority.customerPriorityQueue = customerPriorityQueue;
    }

    public boolean isEmpty() {
        return customerPriorityQueue.isEmpty();
    }
}
