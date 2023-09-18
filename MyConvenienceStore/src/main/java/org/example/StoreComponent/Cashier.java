package org.example.StoreComponent;

import org.example.StoreComponent.Enum.ROLES;

public class Cashier extends Staff{
    public int strike = 0;


    public Cashier() {
    }

    public Cashier(String staffId, String fullName, double monthlySalary, String email, String mobileNumber, ROLES role) {
        super(staffId, fullName, monthlySalary, email, mobileNumber, role);

    }

    public void addStrike(){
        strike++;
    }

    public int getStrike() {
        return 0;
    }
}
