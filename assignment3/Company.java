package assignment3;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Company {
    private Employee employee;
    private HashMap<String,Employee> allEmployees;

    public Company(){
        allEmployees = new HashMap<>();
    }
    public String createEmployee(String employeeID, String name, double grossSalary, String degree, String department){
        String message = "";
        if (!(employeeID.isEmpty() || name.isEmpty())){
            allEmployees.put(employeeID, new Employee(employeeID, name, grossSalary));
            message = String.format("Employee %s was registered successfully.", employeeID);
        }
        return message;
    }
    public String createEmployee(String employeeID, String name, double grossSalary, String degree){
        String message = "";
        if (!(employeeID.isEmpty() || name.isEmpty())){
            allEmployees.put(employeeID, new Employee(employeeID, name, grossSalary));
            message = String.format("Employee %s was registered successfully.", employeeID);
        }
        return message;
    }
    public String createEmployee(String employeeID, String name, double grossSalary, int GPA){
        String message = "";
        allEmployees.put(employeeID, new Intern)
        return message;
    }
    public String createEmployee(String employeeID, String name, double grossSalary){
        String message = "";
        if (!(employeeID.isEmpty() || name.isEmpty())){
            allEmployees.put(employeeID, new Employee(employeeID, name, grossSalary));
            message = String.format("Employee %s was registered successfully.", employeeID);
        }
        return message;
    }
    public String removeEmployee(String employeeID){
        if(allEmployees.get(employeeID) != null){
            allEmployees.remove(employeeID);
            return String.format("Employee %s was successfully removed.", employeeID);
        }
        return  null;
    }
    public String printEmployee(String employeeID){
        return "" + allEmployees.get(employeeID);
    }
    public double getNetSalary(String employeeID){
        return allEmployees.get(employeeID).getNetSalary();
    }
    public void updateName(String employeeID, String newName){
        allEmployees.get(newName).setName(newName);
    }


}
