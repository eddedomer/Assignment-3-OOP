package assignment3;

import assignment3.Expections.InvalidEmployeeDataException;

public class Employee {
    private String employeeID;
    private String name;
    private double initialSalary;

    private final int TRUNCATION_LEVEL = 2;
    private final double BSC_MULTIPLIER = 0.1;
    private final double MSC_MULTIPLIER = 0.2;
    private final double PHD_MULTIPLIER = 0.35;
    private final int DIRECTOR_BONUS = 5000;
    private final int STUDENT_BONUS = 1000;

    private final int HIGH_TAX_BRACKET = 50000;
    private final int LOW_TAX_BRACKET = 30000;
    private final int GPA_HIGH = 8;
    private final int GPA_LOW = 5;

    private final double STANDARD_TAX = 0.1;
    private final double MIDDLE_TAX = 0.2;
    private final double HIGH_TAX = 0.4;

    protected final String BSC_TERM = "BSc";
    protected final String MSC_TERM = "MSc";
    protected final String PHD_TERM = "PhD";

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

    public String getName() { return name; }
    public String getEmployeeID() { return employeeID; }
    public double getInitialSalary() { return initialSalary;}

    public double getGrossSalary() {
        return TruncateValue.toDouble((initialSalary + calcBonus()), TRUNCATION_LEVEL); 
    }

    public double getNetSalary() {
        return TruncateValue.toDouble(getNetSalaryNO_TRUNCATION(), TRUNCATION_LEVEL);
    }

    public double getNetSalaryNO_TRUNCATION() {
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
            if (this instanceof Intern) { //if Intern. No tax
                return 0;
            } else { //Everyone else. Standard Tax
                return (gross) * STANDARD_TAX;
            }
        } else { //if director
            if (gross > HIGH_TAX_BRACKET) {
                return (LOW_TAX_BRACKET * MIDDLE_TAX) + (gross - LOW_TAX_BRACKET) * HIGH_TAX;
            } else if (gross >= LOW_TAX_BRACKET) {
                return (gross * MIDDLE_TAX);
            } else {
                return (gross) * STANDARD_TAX;
            }

        }
    }

    public double calcBonus() {
        double bonus = 0;
        double initSalary = getInitialSalary();
        System.out.println(initSalary);
        if ((this instanceof Director) || (this instanceof Manager)) {
            String degree = ((Manager) this).getDegree();

            if (degree.equals(BSC_TERM)) {
                bonus = initSalary * BSC_MULTIPLIER;
            } else if (degree.equals(MSC_TERM)) {
                bonus = initSalary * MSC_MULTIPLIER;
            } else if (degree.equals(PHD_TERM)) {
                bonus = initSalary * PHD_MULTIPLIER;
            }
            if (this instanceof Director) {
                bonus += DIRECTOR_BONUS;
            }
        } else if (this instanceof Intern) {
            int GPA = ((Intern) this).getGPA();
            if (GPA >= GPA_HIGH) {
                bonus = STUDENT_BONUS;
            } else if ((GPA > GPA_LOW) && (GPA < GPA_HIGH)) {
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