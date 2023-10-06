package assignment3;

public class Manager extends Employee {
    private String degree;
    
    public Manager(String employeeID, String name, double grossSalary, String degree){
        super(employeeID, name, grossSalary);
        this.degree = degree;
    }
    public String getDegree() {
        return degree;
    }
}
