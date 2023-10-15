package assignment3.Expections;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String employeeID) {
        super("Employee " + employeeID + " was not registered yet.");
    }
    public EmployeeNotFoundException() {
        super("No employees registered yet.");
    }
}