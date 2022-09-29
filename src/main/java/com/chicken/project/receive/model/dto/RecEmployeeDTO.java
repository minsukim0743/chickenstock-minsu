package com.chicken.project.receive.model.dto;

import java.util.Date;

public class RecEmployeeDTO {

    private String empName;
    private String empPhone;
    private String empEmail;
    private java.util.Date empBirth;
    private String empId;

    public RecEmployeeDTO() {
    }

    public RecEmployeeDTO(String empName, String empPhone, String empEmail, Date empBirth, String empId) {
        this.empName = empName;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empBirth = empBirth;
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Date getEmpBirth() {
        return empBirth;
    }

    public void setEmpBirth(Date empBirth) {
        this.empBirth = empBirth;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "RecEmployeeDTO{" +
                "empName='" + empName + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empBirth=" + empBirth +
                ", empId='" + empId + '\'' +
                '}';
    }
}
