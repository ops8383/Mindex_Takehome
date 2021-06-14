package com.mindex.challenge.data;

public class Compensation {

    private Employee employee; //assumed that there can only be one Compensation for each employee.
    private Double salary;
    private String effectivDate;

    public Compensation(){}

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public Double getSalary(){
        return salary;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }

    public String getEffectiveDate(){
        return effectivDate;
    }

    public void setEffectiveDate(String effectivDate){
        this.effectivDate = effectivDate;
    }    
}
