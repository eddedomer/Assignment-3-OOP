package assignment3;

import assignment3.Expections.InvalidEmployeeDataException;

public abstract class EmployeeFactory { //abstract because we dont want to make a EmployeeFactory. 

    static public Employee createEmployee(String employeeID, String name, double grossSalary) throws InvalidEmployeeDataException {
        return new Employee(employeeID, name, grossSalary);
    }

    static public Employee createIntern(String employeeID, String name, double grossSalary, int GPA) throws InvalidEmployeeDataException {
        return new Intern(employeeID, name, grossSalary, GPA);
    }

    static public Employee createManager(String employeeID, String name, double grossSalary, String degree) throws InvalidEmployeeDataException {
        return new Manager(employeeID, name, grossSalary, degree);
    }

    static public Employee createDirector(String employeeID, String name, double grossSalary, String degree, String department) throws InvalidEmployeeDataException {
        return new Director(employeeID, name, grossSalary, degree, department);
    }
}
