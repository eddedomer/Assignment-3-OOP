package assignment3;

import assignment3.Expections.InvalidEmployeeDataException;

public class Director extends Manager {
    private String department;

    private final String TECH_DEP = "Technical";
    private final String HUM_RSC_DEP = "Human Resources";
    private final String BUSS_DEP = "Business";
    private final String EXCEP_MESSAGE = "Department must be one of the options: Business, Human Resources or Technical.";

    public Director(String employeeID, String name, double grossSalary, String degree, String department) throws InvalidEmployeeDataException{
        super(employeeID, name, grossSalary, degree);
        if((!department.equals(TECH_DEP) && !department.equals(HUM_RSC_DEP) && !department.equals(BUSS_DEP))){
            throw new InvalidEmployeeDataException(EXCEP_MESSAGE);
        } else {
            this.department = department;
        }
    }
    
    public String getDepartment() { return department; }

    @Override
    public double getGrossSalary() { 
        double grossSalary = super.getGrossSalary() + DIRECTOR_BONUS;
        return grossSalary;
    }

    @Override
    public double getNetSalaryNO_TRUNCATION(){
        double grossSalary = getGrossSalary();
        double netSalary = grossSalary;
        if (grossSalary > HIGH_TAX_BRACKET) {
            netSalary -= ((LOW_TAX_BRACKET * MIDDLE_TAX) + (grossSalary - LOW_TAX_BRACKET) * HIGH_TAX);
        } else if (grossSalary >= LOW_TAX_BRACKET) {
            netSalary -= ((grossSalary * MIDDLE_TAX));
        } else {
            netSalary -= ((grossSalary) * STANDARD_TAX);
        }
        return netSalary;
    }


    public void setDepartment(String newDepartment) throws InvalidEmployeeDataException {
        if((!newDepartment.equals(TECH_DEP) && !newDepartment.equals(HUM_RSC_DEP) && !newDepartment.equals(BUSS_DEP))){
            throw new InvalidEmployeeDataException(EXCEP_MESSAGE);
        } else {
            this.department = newDepartment;
        }
    }

    @Override
    public String toString(){
        return String.format("%s %s's gross salary is %.2f SEK per month. Dept: %s", getDegree(), getName(), getGrossSalary(), department);
    }
}