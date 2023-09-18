package org.example.Services;

import org.example.StoreComponent.Cashier;
import org.example.StoreComponent.CashierApplicant;
import org.example.StoreComponent.Enum.CATEGORY;
import org.example.StoreComponent.Manager;
import org.example.StoreComponent.Staff;

public interface ManagerServices {
    String hireCashierApplicant(Staff staff, CashierApplicant cashierApplicant);

    public boolean sackCashier(String name);
    public void addProduct(String productName, int price, int quantity, CATEGORY categoryName);
    public void removeProduct(String name);
}
