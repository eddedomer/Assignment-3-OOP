package assignment3;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Company {
    private Employee employee;
    private HashMap<String,Employee> employees;

    public Company(){
        employees = new HashMap<>();
    }
    public String createEmployee(String employeeID, String name, double grossSalary, String degree, String department){
        String message = "";
        if (!(employeeID.isEmpty() || name.isEmpty())){
            employees.put(employeeID, new Employee(employeeID, name, grossSalary));
            message = String.format("Employee %s was registered successfully.", employeeID);
        }
        return message;
    }
    public String createEmployee(String employeeID, String name, double grossSalary, String degree){
        String message = "";
        if (!(employeeID.isEmpty() || name.isEmpty())){
            employees.put(employeeID, new Manager(employeeID, name, grossSalary));
            message = String.format("Employee %s was registered successfully.", employeeID);
        }
        return message;
    }
    public String createEmployee(String employeeID, String name, double grossSalary, int GPA){
        String message = "";
        employees.put(employeeID)
        return message;
    }
    public String createEmployee(String employeeID, String name, double grossSalary){
        String message = "";
        if (!(employeeID.isEmpty() || name.isEmpty())){
            employees.put(employeeID, new Employee(employeeID, name, grossSalary));
            message = String.format("Employee %s was registered successfully.", employeeID);
        }
        return message;
    }
    public String removeEmployee(String employeeID){
        if(employees.get(employeeID) != null){
            employees.remove(employeeID);
            return String.format("Employee %s was successfully removed.", employeeID);
        }
        return  null;
    }
    public String printEmployee(String employeeID){
        return "" + employees.get(employeeID);
    }
    public double getNetSalary(String employeeID){
        return employees.get(employeeID).getNetSalary();
    }
    public void updateName(String employeeID, String newName){
        employees.get(employeeID).setName(newName);
    }


}
