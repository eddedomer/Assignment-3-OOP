package assignment3;
public class Employee {
    //EID = Employee ID
    private String employeeID;
    private String name;
    private double grossSalary;

    final int TruncationLevel = 2;
    
    public Employee(String employeeID, String name, double grossSalary){
        this.employeeID = employeeID;
        this.name = name;
        this.grossSalary = TruncateValue.toDouble(grossSalary, TruncationLevel);
    }
    public String getName(){return name;}
    public String getEmployeeID(){return employeeID;}
    public double getGrossSalary(){return grossSalary;}
    public double getNetSalary(){return TruncateValue.toDouble((grossSalary - (grossSalary * 0.1)), TruncationLevel);}
    public void setName(String newName){this.name = newName;}

    public String toString(){
        return String.format("%s's gross salary is %.2f SEK per month.", name, grossSalary);
    }
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        } 
        else if (obj == null || obj instanceof Employee){
            return false;
        }
        Employee otherEmployee = (Employee) obj;
        return this.employeeID.equals(otherEmployee.employeeID);
    }
    public void setGrossSalary(double newGrossSalary) {
    }
    
}