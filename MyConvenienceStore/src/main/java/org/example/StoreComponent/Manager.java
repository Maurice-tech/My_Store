package org.example.StoreComponent;

import org.example.StoreComponent.Enum.ROLES;

public class Manager extends Staff{
    public Manager() {
    }

    public Manager(String staffId, String fullName, double monthlySalary, String email, String mobileNumber, ROLES role) {
        super(staffId, fullName, monthlySalary, email, mobileNumber, role);
    }
}
