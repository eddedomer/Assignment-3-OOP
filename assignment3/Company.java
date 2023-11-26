package assignment3;

import java.util.Map;

import assignment3.Expections.EmployeeNotFoundException;
import assignment3.Expections.RepeatedIDException;

import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;

public class Company {
    private LinkedHashMap<String, Employee> employees;

    //We used LinkedHashMap so that when we print use the method printAllEmployees it works accordingly to the test. Because it keeps all the items stored in order of creation.

    String lineSeperator = System.lineSeparator();
    //so we can use lineSeperator instead of \n

    //Messages
    private String creationSuccessfull(String employeeID){
        return String.format("Employee %s was registered successfully.",employeeID);
    }
    private String updateSuccessfull(String employeeID){
        return String.format("Employee %s was updated successfully",employeeID);
    }
    public Company() {
        employees = new LinkedHashMap<>();
    }

    
    //Getters ------------------------------------------------------------------------------------------------------------------
    public double getNetSalary(String employeeID) throws Exception {
        if (employees.get(employeeID) == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
            return employees.get(employeeID).getNetSalary();
        }
    }

    public String getAllEmployeesAsString() throws EmployeeNotFoundException {
        if (employees.isEmpty()) { //if no employees are registered. Throw NoEmployeeException. 
            throw new EmployeeNotFoundException(); 
        } else {
            String result = "All registered employees:";

            for (Employee employee : employees.values()) {
                result += lineSeperator + employee.toString();
            }

            return result;
        }
    }

    public double getTotalNetSalary() throws EmployeeNotFoundException {
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException();
        } else {
            double totalNetSalary = 0.0;

            for (Employee employee : employees.values()) {
                totalNetSalary = totalNetSalary + employee.getNetSalaryNO_TRUNCATION();
            }

            return TruncateValue.truncateToDouble(totalNetSalary, 2); //uses the TruncateValue.truncateToDouble method to truncate the value to 2 decimalpoints
        }
    }
    
    


    // Employee Creation -------------------------------------------------------------------------------------------------------

    //calls the Mananger Factory
    public String createEmployee(String employeeID, String name, double grossSalary, String degree, String department) throws Exception {
        if (!(employees.get(employeeID) == null)) { //if the employeeID exists throw Repeated ID Exception
            throw new RepeatedIDException(employeeID);
        } else {
            employees.put(employeeID, EmployeeFactory.createDirector(employeeID, name, grossSalary, degree, department));
            return creationSuccessfull(employeeID);
        }
    }

    //calls the Mananger Factory
    public String createEmployee(String employeeID, String name, double grossSalary, String degree) throws Exception {
        if (!(employees.get(employeeID) == null)) {
            throw new RepeatedIDException(employeeID);
        } else {
            employees.put(employeeID, EmployeeFactory.createManager(employeeID, name, grossSalary, degree));
            return creationSuccessfull(employeeID);
        }
    }
    //calls the Intern Factory
    public String createEmployee(String employeeID, String name, double grossSalary, int GPA) throws Exception {
        if (!(employees.get(employeeID) == null)) {
            throw new RepeatedIDException(employeeID);
        } else {
            employees.put(employeeID, EmployeeFactory.createIntern(employeeID, name, grossSalary, GPA));
            return creationSuccessfull(employeeID);
        }
    }
    
    //calls the Employee Factory
    public String createEmployee(String employeeID, String name, double grossSalary) throws Exception {
        if (!(employees.get(employeeID) == null)) {
            throw new RepeatedIDException(employeeID);
        } else {
            employees.put(employeeID, EmployeeFactory.createEmployee(employeeID, name, grossSalary));
            return creationSuccessfull(employeeID);
        }
    }


    public String removeEmployee(String employeeID) throws EmployeeNotFoundException {
        if (employees.get(employeeID) == null) { //if the employee does not exist throw EmployeeNotFoundException
            throw new EmployeeNotFoundException(employeeID);
        } else {
            employees.remove(employeeID);
            return String.format("Employee %s was successfully removed.", employeeID);
        }
    }
    //Promotion-------------------------------------------------------------------------------------------------------------------
        public String promoteToManager(String employeeID, String degree) throws Exception {
        Employee oldEmployee = employees.get(employeeID);
        if (oldEmployee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
            String name = oldEmployee.getName();
            double rawGrossSalary = oldEmployee.getInitialSalary();

            Employee newManager = EmployeeFactory.createManager(employeeID, name, rawGrossSalary, degree);
            //Manager newManager = new Manager(employeeID, name, rawGrossSalary, degree);
            employees.remove(employeeID);
            employees.put(employeeID, newManager);

            return employeeID + " promoted successfully to Manager.";
        }
    }

    public String promoteToDirector(String employeeID, String degree, String department) throws Exception {
        Employee oldEmployee = employees.get(employeeID);
        if (oldEmployee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
            String name = oldEmployee.getName();
            double rawGrossSalary = oldEmployee.getInitialSalary();

            Employee newDirector = EmployeeFactory.createDirector(employeeID, name, rawGrossSalary, degree, department);
            //Director newDirector = new Director(employeeID, name, rawGrossSalary, degree, department);
            employees.remove(employeeID);
            employees.put(employeeID, newDirector);

            return employeeID + " promoted successfully to Director.";
        }
    }

    public String promoteToIntern(String employeeID, int GPA) throws Exception {
        Employee oldEmployee = employees.get(employeeID);
        if (oldEmployee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
            String name = oldEmployee.getName();
            double rawGrossSalary = oldEmployee.getInitialSalary();

            Employee newIntern = EmployeeFactory.createIntern(employeeID, name, rawGrossSalary, GPA);

           // Intern newIntern = new Intern(employeeID, name, rawGrossSalary, GPA);
            employees.remove(employeeID);
            employees.put(employeeID, newIntern);

            return employeeID + " promoted successfully to Intern.";
        }
    }

    //Prints------------------------------------------------------------------------------------------------------------------------
    public String printEmployee(String employeeID) throws EmployeeNotFoundException {
        if (employees.get(employeeID) == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
            return "" + employees.get(employeeID);
        }
    }
    public String printAllEmployees() throws EmployeeNotFoundException {

        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException();
        } else {
            String message = "All registered employees:" + lineSeperator;

            for (Employee employee : employees.values()) {

                message += employee.toString() + lineSeperator;
            }
            return message;
        }
    }
    public String printSortedEmployees() throws EmployeeNotFoundException {
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException();
        } else {

            String result = "Employees sorted by gross salary (ascending order):";

            List<Employee> sortedEmployees = new ArrayList<>(employees.values());
            Collections.sort(sortedEmployees, Comparator.comparingDouble(Employee::getGrossSalary));
             // Here I use the Comparator instead of using a sorting algorithm like buble sort. --Learned from https://www.geeksforgeeks.org/comparator-interface-java/

            for (Employee emp : sortedEmployees) {
                result += lineSeperator + emp.toString();
            }
            result += lineSeperator;

            return result;
        }
    }
    
    public Map<String, Integer> mapEachDegree() throws EmployeeNotFoundException {
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException();
        } else {
            Map<String, Integer> degreeCount = new HashMap<>();

            int bscCount = 0;
            int mscCount = 0;
            int phdCount = 0;

            for (Employee emp : employees.values()) {
                if (emp instanceof Manager || emp instanceof Director) {
                    String degree = ((Manager) emp).getDegree(); //Since the Director Extends the Manager  
                    switch (degree) {                            //we can cast all the Employees as Managers to access the
                        case "BSc":                              //degree even if the employee is a Director. 
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

            if (bscCount > 0) { //if there is noone with this degree we dont want to add that key to the hashmap. 
                degreeCount.put("BSc", bscCount);
            }
            if (mscCount > 0) {
                degreeCount.put("MSc", mscCount);
            }
            if (phdCount > 0) {
                degreeCount.put("PhD", phdCount);
            }

            return degreeCount;
        }
    }


    //Updaters/setters------------------------------------------------------------------------------------------------------------------------
    
    public String updateEmployeeName(String employeeID, String newName) throws Exception {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
            employee.setName(newName);
            return updateSuccessfull(employeeID);
        }
    }

    public String updateGrossSalary(String employeeID, double newGrossSalary) throws Exception {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
            employee.setGrossSalary(newGrossSalary);
            return updateSuccessfull(employeeID);
        }
    }

    public String updateManagerDegree(String employeeID, String newDegree) throws Exception {
        Employee employee = employees.get(employeeID);
        if (employee == null) {
            throw new EmployeeNotFoundException(employeeID);
        } else {
            if (employee instanceof Manager || employee instanceof Director) {
                ((Manager) employee).setDegree(newDegree);
                return updateSuccessfull(employeeID);
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
                return updateSuccessfull(employeeID);
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
                return updateSuccessfull(employeeID);
            } else {
                return null;
            }
        }
    }

}
