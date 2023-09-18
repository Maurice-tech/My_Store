package org.example;


import org.example.Function.Fifo;
import org.example.Function.Priority;
import org.example.Services.ServicesImpl.CashierServicesImpl;
import org.example.Services.ServicesImpl.CustomerServicesImpl;
import org.example.Services.ServicesImpl.ManagerServicesImpl;
import org.example.Services.ServicesImpl.ProductsManagementImpl;
import org.example.StoreComponent.*;
import org.example.StoreComponent.Enum.CATEGORY;
import org.example.StoreComponent.Enum.QUALIFICATION;
import org.example.StoreComponent.Enum.ROLES;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("001", "Maurice Irene", 200000.00, "maurice@email.com", "087659", ROLES.MANAGER );
        System.out.println(" ");

        ManagerServicesImpl managerServices = new ManagerServicesImpl();
        System.out.println(" ");



        managerServices.hireCashierApplicant(manager, new CashierApplicant("Aisha", 27,"111", QUALIFICATION.BSC));
        managerServices.hireCashierApplicant(manager, new CashierApplicant("Musa", 30,"122", QUALIFICATION.HND));
        managerServices.hireCashierApplicant(manager, new CashierApplicant("Amaka", 15,"133", QUALIFICATION.BSC));

        Cashier cashier1 = new Cashier("002", "Aisha", 100000.00,"mary@gmail.com", "021233",ROLES.CASHIER);
        Cashier cashier2 = new Cashier("003", "Musa", 100000.00,"rita@gmail.com", "098833",ROLES.CASHIER);
        Cashier cashier3 = new Cashier("004", "Aisha", 100000.00,"jane@gmail.com", "0344455",ROLES.CASHIER);

        System.out.println(" ");
        System.out.println(ManagerServicesImpl.getCashier());

        System.out.println(" ");
        managerServices.sackCashier("Musa");
        managerServices.sackCashier("Aisha");



        System.out.println(" ");
        managerServices.addProduct("Mirinda",150,30, CATEGORY.NON_ALCOHOLIC_DRINKS);


        System.out.println(" ");
        managerServices.removeProduct("Mirinda");


        System.out.println(" ");
//        System.out.println(ManagerServicesImpl.getProductMap());


        ProductsManagementImpl productsManagement = new ProductsManagementImpl();
        productsManagement.addProductsToStore(); // Load products into pI's map
        productsManagement.viewItems(ManagerServicesImpl.getProductMap());


        System.out.println(" ");
        managerServices.addProduct("Mirinda",150,30,CATEGORY.NON_ALCOHOLIC_DRINKS);
        managerServices.addProduct("coke",150,25,CATEGORY.NON_ALCOHOLIC_DRINKS);
        managerServices.addProduct("Shampoos",150,5,CATEGORY.COSMETICS);
        managerServices.addProduct("Coffee",150,14,CATEGORY.BEVERAGES);
        managerServices.addProduct("fanta",150,35,CATEGORY.NON_ALCOHOLIC_DRINKS);
        managerServices.addProduct("pies",150,21,CATEGORY.BAKERIES);

        ProductsManagementImpl.writeProductsToCSV(ManagerServicesImpl.getProductMap(),"src/main/resources/Product.csv");
        productsManagement.viewItems(ManagerServicesImpl.getProductMap());

        Customer customer1 = new Customer("Blessing", 190, "099887", 60000.0);
        Customer customer2 = new Customer("Ebuka", 200, "023387", 30000.0);
        Customer customer3 = new Customer("Ada", 300, "022887", 10000.0);
        Customer customer4 = new Customer("Vicky", 112, "0349887", 20000.0);
        Customer customer5 = new Customer("John", 122, "449887", 40000.0);

        CustomerServicesImpl customerServices1 = new CustomerServicesImpl(customer1);
        CustomerServicesImpl customerServices2 = new CustomerServicesImpl(customer2);
        CustomerServicesImpl customerServices3 = new CustomerServicesImpl(customer3);
        CustomerServicesImpl customerServices4 = new CustomerServicesImpl(customer4);
        CustomerServicesImpl customerServices5 = new CustomerServicesImpl(customer5);


        customerServices1.addToCart("Life",20);
        customerServices1.addToCart("Cookies",30);
        productsManagement.viewItems(ManagerServicesImpl.getProductMap());
        System.out.println(" ");
        customerServices2.addToCart("Coke",15);
        customerServices2.addToCart("Star",25);
        productsManagement.viewItems(ManagerServicesImpl.getProductMap());
        System.out.println(" ");
        customerServices3.addToCart("Shampoos",30);
        customerServices3.addToCart("Pies",15);
        productsManagement.viewItems(ManagerServicesImpl.getProductMap());
        System.out.println(" ");
        customerServices4.addToCart("Sprite",18);
        customerServices4.addToCart("Fanta",16);
        productsManagement.viewItems(ManagerServicesImpl.getProductMap());
        customerServices5.addToCart("Coffee",12);
        customerServices5.addToCart("Bread",10);
        productsManagement.viewItems(ManagerServicesImpl.getProductMap());
        System.out.println(" ");



        System.out.println(" ");
        customerServices1.buyProduct();
        System.out.println(" ");
        customerServices2.buyProduct();
        System.out.println(" ");
        customerServices3.buyProduct();
        System.out.println(" ");

        Fifo fifo = new Fifo();

        fifo.enqueue(customerServices1);
        fifo.enqueue(customerServices2);
        fifo.enqueue(customerServices3);

        System.out.println(" ");
        System.out.println(Fifo.getCustomerQueue());

        CashierServicesImpl cashierServices = new CashierServicesImpl();
        System.out.println(" ");
        cashierServices.dispensesReceipts(cashier1);
        System.out.println(" ");
        cashierServices.dispensesReceipts(cashier2);
        System.out.println(" ");
        cashierServices.dispensesReceipts(cashier3);
        System.out.println(" ");

        new Priority();

        Priority.enqueue(customerServices1);
        Priority.enqueue(customerServices2);
        Priority.enqueue(customerServices3);

        System.out.println(" ");
        System.out.println(Priority.getCustomerPriorityQueue());

        System.out.println(" ");
        cashierServices.dispensesReceipts2(cashier1);
        System.out.println(" ");
        cashierServices.dispensesReceipts2(cashier2);
        System.out.println(" ");
        cashierServices.dispensesReceipts2(cashier3);
        System.out.println(" ");



        









    }
}