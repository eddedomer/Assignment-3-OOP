package assignment3;

import assignment3.Expections.InvalidEmployeeDataException;

public class Employee {
    private String employeeID;
    private String name;
    private double initialSalary;

    final int TRUNCATION_LEVEL = 2;
    final double BSC_MULTIPLIER = 0.1;
    final double MSC_MULTIPLIER = 0.2;
    final double PHD_MULTIPLIER = 0.35;
    final int DIRECTOR_BONUS = 5000;
    final int STUDENT_BONUS = 1000;

    final int HIGH_TAX_BRACKET = 50000;
    final int LOW_TAX_BRACKET = 30000;

    final double STANDARD_TAX = 0.1;
    final double MIDDLE_TAX = 0.2;
    final double HIGH_TAX = 0.4;

    public Employee(String employeeID, String name, double initialSalary) throws InvalidEmployeeDataException {
        if (employeeID.isEmpty()) {
            throw new InvalidEmployeeDataException("ID cannot be blank.");
        } else if (name.trim().isEmpty()) {
            throw new InvalidEmployeeDataException("Name cannot be blank.");
        } else if (initialSalary <= 0) {
            throw new InvalidEmployeeDataException("Salary must be greater than zero.");
        } else {
            this.employeeID = employeeID;
            this.name = name;
            this.initialSalary = TruncateValue.toDouble(initialSalary, TRUNCATION_LEVEL);
        }
    }

    public String getName() {
        return name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public double getInitialSalary() {
        return initialSalary;
    }

    public double getGrossSalary() {
        return TruncateValue.toDouble((initialSalary + calcSalary()), TRUNCATION_LEVEL);
    }

    public double getNetSalary() {
        return TruncateValue.toDouble(getNetSalaryInternal(), TRUNCATION_LEVEL);
    }

    public double getNetSalaryInternal() {
        return getGrossSalary() - calcTax();
    }

    public void setGrossSalary(double newGrossSalary) throws InvalidEmployeeDataException {
        if (newGrossSalary <= 0) {
            throw new InvalidEmployeeDataException("Salary must be greater than zero.");
        } else {
            initialSalary = newGrossSalary;
        }
    }

    public void setName(String newName) throws InvalidEmployeeDataException {
        if (newName.trim().isEmpty()) {
            throw new InvalidEmployeeDataException("Name cannot be blank.");
        } else {
            this.name = newName;
        }
    }

    public double calcTax() {
        double gross = getGrossSalary();
        if (!(this instanceof Director)) {
            if (this instanceof Intern) {
                return 0;
            } else {
                return (gross) * STANDARD_TAX;
            }
        } else {
            if (gross > HIGH_TAX_BRACKET) {
                return (LOW_TAX_BRACKET * MIDDLE_TAX) + (gross - LOW_TAX_BRACKET) * HIGH_TAX;
            } else if (gross >= LOW_TAX_BRACKET) {
                return (gross * MIDDLE_TAX);
            } else {
                return (gross) * STANDARD_TAX;
            }

        }
    }

    public double calcSalary() {
        double bonus = 0;
        double initSalary = getInitialSalary();
        String degree = "";
        System.out.println(initSalary);
        if ((this instanceof Director) || (this instanceof Manager)) {

            if (this instanceof Manager) {
                degree = ((Manager) this).getDegree();
            } else {
                degree = ((Director) this).getDegree();
            }
            if (degree.equals("BSc")) {
                bonus = initSalary * BSC_MULTIPLIER;
            } else if (degree.equals("MSc")) {
                bonus = initSalary * MSC_MULTIPLIER;
            } else if (degree.equals("PhD")) {
                bonus = initSalary * PHD_MULTIPLIER;
            }
            if (this instanceof Director) {
                bonus += DIRECTOR_BONUS;
            }
        } else if (this instanceof Intern) {
            int GPA = ((Intern) this).getGPA();
            if (GPA >= 8) {
                bonus = STUDENT_BONUS;
            } else if ((GPA > 5) && (GPA < 8)) {
                bonus = 0;
            } else {
                bonus = -initSalary;
            }
        }
        System.out.println(bonus);
        return bonus;
    }

    public String toString() {
        return String.format("%s's gross salary is %.2f SEK per month.", name, getGrossSalary());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj instanceof Employee) {
            return false;
        }
        Employee otherEmployee = (Employee) obj;
        return this.employeeID.equals(otherEmployee.employeeID);
    }

}