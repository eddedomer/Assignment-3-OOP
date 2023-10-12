package assignment3;

import assignment3.Expections.InvalidEmployeeDataException;

public class Manager extends Employee {
    private String degree;
    
    
    public Manager(String employeeID, String name, double grossSalary, String degree)throws InvalidEmployeeDataException{
        super(employeeID, name, grossSalary);
        this.degree = degree; 
    }
    public String getDegree() {
        return degree;
    }
    
    public void setDegree(String newDegree) {
        this.degree = newDegree;
    }
    @Override
    public String toString(){
        return String.format("%s %s's gross salary is %.2f SEK per month.", degree, getName(), getGrossSalary());
    }
    
}
// String representation for Managers:
// <degree> <name>’s gross salary is <gross_salary> SEK per month.

// String representation for Directors (note: all in the same line):
//<degree> <name>’s gross salary is <gross_salary> SEK per month. Dept: <department>

// String representation for Interns:
// <name>’s gross salary is <gross_salary> SEK per month. GPA: <gpa>
