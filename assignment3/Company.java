package assignment3;
import java.util.ArrayList;
import java.util.HashMap;

public class Company {
    private Employee employee;
    private HashMap<String,Employee> allEmployees;

    public Company(){
        allEmployees = new HashMap<>();
    }
    public String createEmployee(String employeeID, String name, double grossSalary){
        String message = "";
        if (!(employeeID.isEmpty() || name.isEmpty())){
            allEmployees.put(employeeID,new Employee(employeeID, name, grossSalary));
            message = String.format("Employee %s was registered successfully.", employeeID);
        }
        return message;
    }
    public String printEmployee(String employeeID){
        return "" + allEmployees.get(employeeID);
    }
    public double getNetSalary(String employeeID){
        return allEmployees.get(employeeID).getNetSalary();
    }
}
