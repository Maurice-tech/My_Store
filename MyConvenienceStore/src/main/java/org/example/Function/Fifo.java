package org.example.Function;

import org.example.Services.ServicesImpl.CustomerServicesImpl;

import java.util.LinkedList;
import java.util.Queue;

public class Fifo {
    private static Queue<CustomerServicesImpl> customerQueue = new LinkedList<>();
    public static void enqueue(CustomerServicesImpl customer) {
        customerQueue.offer(customer);
    }
    public static CustomerServicesImpl dequeue() {
        return customerQueue.poll();
    }
    public static Queue<CustomerServicesImpl> getCustomerQueue() {
        return customerQueue;
    }

    public boolean isEmpty() {
        return customerQueue.isEmpty();
    }


//    public static boolean getCustomerQueue() {
//        return true;
//    }



//    public boolean isEmpty() {
//        return customerQueue.isEmpty();
//    }

}
