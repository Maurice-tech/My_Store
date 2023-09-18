package org.example.StoreComponent;

import org.example.StoreComponent.Enum.ROLES;

public class Staff {
    private String staffId;
    private String fullName;
    private double monthlySalary;
    private String Email;
    private String mobileNumber;
    private static ROLES role;

    public Staff() {
    }

    public Staff(String staffId, String fullName, double monthlySalary, String email, String mobileNumber, ROLES role) {
        this.staffId = staffId;
        this.fullName = fullName;
        this.monthlySalary = monthlySalary;
        Email = email;
        this.mobileNumber = mobileNumber;
        this.role = role;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public static ROLES getRole() {
        return role;
    }

    public void setRole(ROLES role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId='" + staffId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", monthlySalary=" + monthlySalary +
                ", Email='" + Email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", role=" + role +
                '}';
    }
}
