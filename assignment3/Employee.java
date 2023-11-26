package assignment3;

import assignment3.Expections.InvalidEmployeeDataException;

public class Employee {
    private String employeeID;
    private String name;
    private double initialSalary;

    protected final int TRUNCATION_LEVEL = 2;
    protected final double BSC_MULTIPLIER = 0.1;
    protected final double MSC_MULTIPLIER = 0.2;
    protected final double PHD_MULTIPLIER = 0.35;
    protected final int DIRECTOR_BONUS = 5000;
    protected final int STUDENT_BONUS = 1000;

    protected final int HIGH_TAX_BRACKET = 50000;
    protected final int LOW_TAX_BRACKET = 30000;
    protected final int GPA_HIGH = 8;
    protected final int GPA_LOW = 5;

    protected final double STANDARD_TAX = 0.1;
    protected final double MIDDLE_TAX = 0.2;
    protected final double HIGH_TAX = 0.4;

    protected final String BSC_TERM = "BSc";
    protected final String MSC_TERM = "MSc";
    protected final String PHD_TERM = "PhD";

    public Employee(String employeeID, String name, double initialSalary) throws InvalidEmployeeDataException {
        if (employeeID.isEmpty()) {
            throw new InvalidEmployeeDataException("ID cannot be blank.");
        } else if (name.trim().isEmpty()) {
            throw new InvalidEmployeeDataException("Name cannot be blank.");
        } else if (initialSalary <= 0) {
            throw new InvalidEmployeeDataException("Salary must be greater than zero.");
        } else {
            this.employeeID = employeeID;
            this.name = name;
            this.initialSalary = TruncateValue.truncateToDouble(initialSalary, TRUNCATION_LEVEL);
        }
    }

    public String getName() { return name; }
    public String getEmployeeID() { return employeeID; }
    public double getInitialSalary() { return initialSalary;}
    public double getGrossSalary() { return TruncateValue.truncateToDouble(getInitialSalary(), TRUNCATION_LEVEL);}
    public double getNetSalary() { return TruncateValue.truncateToDouble(getNetSalaryNO_TRUNCATION(), TRUNCATION_LEVEL); }

    public double getNetSalaryNO_TRUNCATION() {
        return getGrossSalary() - getGrossSalary() * STANDARD_TAX;
    }

    public void setGrossSalary(double newGrossSalary) throws InvalidEmployeeDataException {
        if (newGrossSalary <= 0) {
            throw new InvalidEmployeeDataException("Salary must be greater than zero.");
        } else {
            initialSalary = newGrossSalary;
        }
    }

    public void setName(String newName) throws InvalidEmployeeDataException {
        if (newName.trim().isEmpty()) {
            throw new InvalidEmployeeDataException("Name cannot be blank.");
        } else {
            this.name = newName;
        }
    }

    public String toString() {
        return String.format("%s's gross salary is %.2f SEK per month.", name, getGrossSalary());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj instanceof Employee) {
            return false;
        }
        Employee otherEmployee = (Employee) obj;
        return this.employeeID.equals(otherEmployee.employeeID);
    }

}