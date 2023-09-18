package org.example.StoreComponent;

import org.example.StoreComponent.Enum.QUALIFICATION;

public class CashierApplicant {
    private String applicantName;
    private Integer age;
    private String applicantNumber;
    private QUALIFICATION qualification;

    public CashierApplicant(String applicantName, Integer age, String applicantNumber, QUALIFICATION qualification) {
        this.applicantName = applicantName;
        this.age = age;
        this.applicantNumber = applicantNumber;
        this.qualification = qualification;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getApplicantNumber() {
        return applicantNumber;
    }

    public void setApplicantNumber(String applicantNumber) {
        this.applicantNumber = applicantNumber;
    }

    public QUALIFICATION getQualification() {
        return qualification;
    }

    public void setQualification(QUALIFICATION qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "CashierApplicant{" +
                "applicantName='" + applicantName + '\'' +
                ", age=" + age +
                ", applicantNumber='" + applicantNumber + '\'' +
                ", qualification=" + qualification +
                '}';
    }
}
