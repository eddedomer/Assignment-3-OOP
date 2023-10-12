package assignment3;
import java.util.Map;

import assignment3.Expections.EmployeeNotFoundException;
import assignment3.Expections.InvalidEmployeeDataException;
import assignment3.Expections.NoEmployeeException;
import assignment3.Expections.RepeatedIDException;

import java.util.Collections;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;

public class Company {
    private Employee employee;
    private LinkedHashMap<String, Employee> employees;
    
   // Design Task 2 - Factory of Employees:
   // One of the challenges in a hierarchy of classes is to define the Creator, which is the responsibility to create instances of many subclasses in a Hierarchy. 
   // A clean solution is to apply a design pattern that creates an abstraction whose single responsibility is to create the correct instances of subclasses to be used. 
   // This abstraction is called a Factory Method.
   // To complete this design task, you must:
   // Implement a Factory Method in your project for the responsibility to create all different types of employees.
   // Write the “Section 4” in your individual report.


    public Company() {
        employees = new LinkedHashMap<>();
    }


    public String createEmployee (String employeeID, String name, double grossSalary, String degree, String department)throws Exception { //director
        if (!(employees.get(employeeID) == null)){
            throw new RepeatedIDException(employeeID);
        } else {
            employees.put(employeeID, EmployeeFactory.createDirector(employeeID, name, grossSalary, degree, department));
        return CompanyMessages.creationSuccessfull(employeeID);
        }
    }
    public String createEmployee(String employeeID, String name, double grossSalary, String degree)throws Exception {
        if (!(employees.get(employeeID) == null)){
            throw new RepeatedIDException(employeeID);
        } else {
            employees.put(employeeID, EmployeeFactory.createManager(employeeID, name, grossSalary, degree));
        return CompanyMessages.creationSuccessfull(employeeID);
        }
    }
    public String createEmployee(String employeeID, String name, double grossSalary, int GPA)throws Exception{
        if (!(employees.get(employeeID) == null)){
            throw new RepeatedIDException(employeeID);
        } else {
            employees.put(employeeID, EmployeeFactory.createIntern(employeeID, name, grossSalary, GPA));
        return CompanyMessages.creationSuccessfull(employeeID);
        }
    }
    public String createEmployee(String employeeID, String name, double grossSalary)throws Exception {
        if (!(employees.get(employeeID) == null)){
            throw new RepeatedIDException(employeeID);
        } else{
            employees.put(employeeID, EmployeeFactory.createEmployee(employeeID, name, grossSalary));
        return CompanyMessages.creationSuccessfull(employeeID);
        }
    }

    public String removeEmployee(String employeeID) throws EmployeeNotFoundException {
        if (employees.get(employeeID) == null){
            throw new EmployeeNotFoundException(employeeID);
        }else {
            employees.remove(employeeID);
            return String.format("Employee %s was successfully removed.", employeeID);
       }
    }

    public String printEmployee(String employeeID) throws EmployeeNotFoundException {
       if (employees.get(employeeID) == null){
        throw new EmployeeNotFoundException(employeeID);
       } else {
        return "" + employees.get(employeeID);
       }
    }

    public double getNetSalary(String employeeID) throws Exception{
        if (employees.get(employeeID) == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
        return employees.get(employeeID).getNetSalary();
        }
    }

    public String printAllEmployees() throws NoEmployeeException{
    
    if (employees.isEmpty()){
        throw new NoEmployeeException();
    } else{
        String message = "All registered employees:\n";
        
        for (Employee employee : employees.values()){

            message += employee.toString() + "\n";
        }
        return message;
        }
    }
    

    //// Här kommer mina koder /////







    

    public String getAllEmployeesAsString()throws NoEmployeeException{
        if (employees.isEmpty()){
            throw new NoEmployeeException();
        } else{
            String result = "All registered employees:";

        for (Employee employee : employees.values()) {
            result += "\n" + employee.toString();
        }

        return result;
    }
    }

    public double getTotalNetSalary() throws NoEmployeeException{
        if (employees.isEmpty()){
            throw new NoEmployeeException();
        } else {
        double totalNetSalary = 0.0;

        for (Employee employee : employees.values()) {
            totalNetSalary = totalNetSalary + employee.getNetSalaryInternal();
        }
        
        return TruncateValue.toDouble(totalNetSalary, 2);
    }
    }

    public String printSortedEmployees() throws NoEmployeeException {
        if(employees.isEmpty()){
            throw new NoEmployeeException();
        } else{

        String result = "Employees sorted by gross salary (ascending order):";

        List<Employee> sortedEmployees = new ArrayList<>(employees.values());
        Collections.sort(sortedEmployees, Comparator.comparingDouble(Employee::getGrossSalary)); // Here I use the Comparator instead of using a sorting algorithm like buble sort.
                                                                                           
        for (Employee emp : sortedEmployees) {
            result += "\n" + emp.toString();
        }
        result += "\n";

        return result;
    }
    }

    public String updateEmployeeName(String employeeID, String newName) throws Exception {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
            employee.setName(newName);
            return CompanyMessages.updateSuccessfull(employeeID);
        }
    }
    
    public String updateGrossSalary(String employeeID, double newGrossSalary) throws Exception{
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
            employee.setGrossSalary(newGrossSalary);
                return CompanyMessages.updateSuccessfull(employeeID);
        }
    }
    
    public String updateManagerDegree(String employeeID, String newDegree) throws Exception{
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
        if (employee instanceof Manager) {
            ((Manager) employee).setDegree(newDegree);
            return CompanyMessages.updateSuccessfull(employeeID);
        } else if (employee instanceof Director) {
            ((Director) employee).setDegree(newDegree);
            return CompanyMessages.updateSuccessfull(employeeID);
        } else {
            return null;
        }
        } 
    }
    
    public String updateDirectorDept(String employeeID, String newDepartment) throws Exception {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
        if (employee instanceof Director) {
            ((Director) employee).setDepartment(newDepartment);
            return CompanyMessages.updateSuccessfull(employeeID);
        } else {
         return null;
        }
    }
    }
    
    public String updateInternGPA(String employeeID, int newGPA) throws Exception {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
        if (employee instanceof Intern) {
            ((Intern) employee).setGPA(newGPA);
            return CompanyMessages.updateSuccessfull(employeeID);
        } else {
            return null;
        }
    }
    }

   /*public String promoteToManager(String empID, String degree){
        HashMap <String, Object> savedInfo = saveInfo(empID);
        removeEmployee(empID);
        

        return null;
    }*/
    public HashMap<String, Object> saveInfo(String empID){
        HashMap<String, Object> savedInfo = new HashMap<>();
        Employee emp = employees.get(empID);
        savedInfo.put("name", emp.getName());
        savedInfo.put("initSalary", emp.getInitialSalary());

        return savedInfo;
    }

    public Map<String, Integer> mapEachDegree() throws NoEmployeeException {
      if (employees.isEmpty()){
        throw new NoEmployeeException();
      } else {
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
    
    public String promoteToManager(String employeeID, String degree) throws Exception{
        Employee oldEmployee = employees.get(employeeID);
        if (oldEmployee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
        String name = oldEmployee.getName();
        double rawGrossSalary = oldEmployee.getInitialSalary();
        Manager newManager = new Manager(employeeID, name, rawGrossSalary, degree);
        employees.remove(employeeID);
        employees.put(employeeID, newManager);
    
        return employeeID + " promoted successfully to Manager.";
        }
    }
    
    public String promoteToDirector(String employeeID, String degree, String department) throws Exception{
        Employee oldEmployee = employees.get(employeeID);
        if (oldEmployee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
        String name = oldEmployee.getName();
        double rawGrossSalary = oldEmployee.getInitialSalary();
        Director newDirector = new Director(employeeID, name, rawGrossSalary, degree, department);
        employees.remove(employeeID);
        employees.put(employeeID, newDirector);
        
    
        return  employeeID + " promoted successfully to Director.";
        }
    }
    
    public String promoteToIntern(String employeeID, int GPA) throws Exception{
        Employee oldEmployee = employees.get(employeeID);
        if (oldEmployee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
        String name = oldEmployee.getName();
        double rawGrossSalary = oldEmployee.getInitialSalary();
        Intern newIntern = new Intern(employeeID, name, rawGrossSalary, GPA);
        employees.remove(employeeID);
        employees.put(employeeID, newIntern);
    
        return employeeID + " promoted successfully to Intern.";
        }
    }
    
    
    
}
