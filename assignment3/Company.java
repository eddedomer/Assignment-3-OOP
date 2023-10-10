package assignment3;
import java.util.Map;
import java.util.Collections;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;

public class Company {
    private Employee employee;
    private LinkedHashMap<String, Employee> employees;
    
    
    public Company() {
        employees = new LinkedHashMap<>();
    }

    public String createEmployee(String employeeID, String name, double grossSalary, String degree, String department) { //director
        String message = "";
        if (!(employeeID.isEmpty() || name.isEmpty())) {
            employees.put(employeeID, new Director(employeeID, name, grossSalary, degree, department));
            message = String.format("Employee %s was registered successfully.", employeeID);
        }
        return message;
    }

    public String createEmployee(String employeeID, String name, double grossSalary, String degree) {
        String message = "";
        if (!(employeeID.isEmpty() || name.isEmpty())) {
            employees.put(employeeID, new Manager(employeeID, name, grossSalary, degree));
            message = String.format("Employee %s was registered successfully.", employeeID);
        }
        return message;
    }

    public String createEmployee(String employeeID, String name, double grossSalary, int GPA){
        String message = "";
       employees.put(employeeID, new Intern(employeeID, name, grossSalary, GPA));
        message = String.format("Employee %s was registered successfully.", employeeID);

        return message;
    }

    public String createEmployee(String employeeID, String name, double grossSalary) {
        String message = "";
        if (!(employeeID.isEmpty() || name.isEmpty())) {
            employees.put(employeeID, new Employee(employeeID, name, grossSalary));
            message = String.format("Employee %s was registered successfully.", employeeID);
        }
        return message;
    }

    public String removeEmployee(String employeeID) {
        if (employees.get(employeeID) != null) {
            employees.remove(employeeID);
            return String.format("Employee %s was successfully removed.", employeeID);
       }
       return null;
    }

    public String printEmployee(String employeeID) {
        return "" + employees.get(employeeID);
    }

    public double getNetSalary(String employeeID) {
        return employees.get(employeeID).getNetSalary();
    }

    public void updateName(String employeeID, String newName) {
        employees.get(employeeID).setName(newName);
    }

    public String printAllEmployees(){
        String message = "All registered employees:\n";
        
        for (Employee employee : employees.values()){

            message += employee.toString() + "\n";
        }
        return message;
    }

    //// Här kommer mina koder /////







    

    public String getAllEmployeesAsString() {
        String result = "All registered employees:";

        for (Employee employee : employees.values()) {
            result += "\n" + employee.toString();
        }

        return result;

    }

    public String getTotalNetSalary() {
        double totalNetSalary = 0.0;

        for (Employee employee : employees.values()) {
            totalNetSalary += employee.getNetSalary();
        }

        String formattedTotal = String.format("Total net salary: %.2f SEK", TruncateValue.toDouble(totalNetSalary, 2));
        return formattedTotal;
    }

    public String getEmployeesSortedByGrossSalary() {
        String result = "Employees sorted by gross salary (ascending order):";

        List<Employee> sortedEmployees = new ArrayList<>(employees.values());
        Collections.sort(sortedEmployees, Comparator.comparingDouble(Employee::getGrossSalary)); // Here I use the Comparator instead of using a sorting algorithm like buble sort.
                                                                                           
        for (Employee emp : sortedEmployees) {
            result += "\n" + emp.toString();
        }

        return result;
    }

    public String updateEmployeeInformation(String employeeID, String newName, double newGrossSalary, String newDegree, String newDepartment, int newGPA) {
        Employee employee = employees.get(employeeID);

        if (employee != null) {
            if (employee instanceof Manager) {
                Manager manager = (Manager) employee;
                manager.setDegree(newDegree);
            } else if (employee instanceof Director) {
                Director director = (Director) employee;
                director.setDegree(newDegree);
                director.setDepartment(newDepartment);
            } else if (employee instanceof Intern) {
                Intern intern = (Intern) employee;
                intern.setGPA(newGPA);
            }

            employee.setName(newName);
            employee.setGrossSalary(newGrossSalary);

            return "Employee " + employeeID + " was updated successfully.";
        } else {
            return "Employee " + employeeID + " was not found.";
        }
    }

    public Map<String, Integer> mapEachDegree() {
        Map<String, Integer> degreeCount = new HashMap<>();
        
        int bscCount = 0;
        int mscCount = 0;
        int phdCount = 0;

        for (Employee emp : employees.values()) {
            if (emp instanceof Manager) {
                String degree = ((Manager) emp).getDegree();
                switch (degree) {
                    case "BSc":
                        bscCount++;
                        break;
                    case "MSc":
                        mscCount++;
                        break;
                    case "PhD":
                        phdCount++;
                        break;
                    default:
                }
            } else if (emp instanceof Director) {
                String degree = ((Director) emp).getDegree();
                switch (degree) {
                    case "BSc":
                        bscCount++;
                        break;
                    case "MSc":
                        mscCount++;
                        break;
                    case "PhD":
                        phdCount++;
                        break;
                    default:
                }
            }
        }

        if (bscCount > 0) {degreeCount.put("BSc", bscCount);}
        if (mscCount > 0) {degreeCount.put("MSc", mscCount);}
        if (phdCount > 0) {degreeCount.put("PhD", phdCount);}
    
        return degreeCount;
    }
    
    
    
    
}
