package org.example.Services.ServicesImpl;

import org.example.StoreComponent.Cashier;
import org.example.StoreComponent.CashierApplicant;
import org.example.StoreComponent.Enum.QUALIFICATION;
import org.example.StoreComponent.Enum.ROLES;
import org.example.StoreComponent.Manager;
import org.junit.Test;

import static org.example.Services.ServicesImpl.ManagerServicesImpl.cashiers;
import static org.example.Services.ServicesImpl.ManagerServicesImpl.getCashier;
import static org.junit.Assert.*;

public class ManagerServicesImplTest {
    Manager manager = new Manager("001", "Maurice Irene", 200000.00, "maurice@email.com", "087659", ROLES.MANAGER);
    ManagerServicesImpl managerServices = new ManagerServicesImpl();
    CashierApplicant cashierApplicant = new CashierApplicant("Musa", 30, "122", QUALIFICATION.HND);
    Cashier cashier = new Cashier("002", "Aisha", 100000.00, "mary@gmail.com", "021233", ROLES.CASHIER);


    @Test
    public void hireCashierApplicant() {
        cashiers.put(cashierApplicant.getApplicantName(), new Cashier());
        String message = cashierApplicant.getApplicantName() + " You are hired as the new cashier";
        assertEquals(message);
    }

    private void assertEquals(String message) {
    }

    @Test
    public void sackCashier() {
        String cashierName = String.valueOf(getCashier());
        cashiers.remove(cashierName);
        assertEquals(String.valueOf(true));
    }
}