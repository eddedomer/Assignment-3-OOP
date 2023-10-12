package assignment3;

import assignment3.Expections.InvalidEmployeeDataException;

public class Director extends Employee {
    private String degree;
    private String department;

    public Director(String employeeID, String name, double grossSalary, String degree, String department) throws InvalidEmployeeDataException{
        super(employeeID, name, grossSalary);
        this.degree = degree;
        this.department = department;
    }

    public String getDegree() {
        return degree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String newDepartment) {
        this.department = newDepartment;
    }

    public void setDegree(String newDegree) {
        this.degree = newDegree;
    }
    @Override
    public String toString(){
        return String.format("%s %s's gross salary is %.2f SEK per month. Dept: %s", degree, getName(), getGrossSalary(), department);
    }
}