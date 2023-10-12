package assignment3;

import assignment3.Expections.InvalidEmployeeDataException;

public class Employee {
    //EID = Employee ID
    private String employeeID;
    private String name;
    private double initialSalary;


    final int TruncationLevel = 2;
    final double BScMultiplier = 0.1;
    final double MScMultiplier = 0.2;
    final double PhDMultiplier = 0.35;
    final int directorBonus = 5000;
    final int studentBonus = 1000;

    final int highTaxBracket = 50000;
    final int lowTaxBracket = 30000;

    final double standardTax = 0.1;
    final double middleTax = 0.2;
    final double highTax = 0.4;

    
    public Employee(String employeeID, String name, double initialSalary) throws InvalidEmployeeDataException{
        if (employeeID.isEmpty()){
            throw new InvalidEmployeeDataException("ID cannot be blank.");
        } else if (name.trim().isEmpty()){
            throw new InvalidEmployeeDataException("Name cannot be blank.");
        } else if (initialSalary <= 0){
            throw new InvalidEmployeeDataException("Salary must be greater than zero.");
        }else {
        this.employeeID = employeeID;
        this.name = name;
        this.initialSalary = TruncateValue.toDouble(initialSalary, TruncationLevel);
        }
    }
    public String getName(){return name;}
    public String getEmployeeID(){return employeeID;}
    public double getInitialSalary(){return initialSalary;}
    public double getGrossSalary(){return TruncateValue.toDouble((initialSalary + calcSalary()), TruncationLevel);}
    public double getNetSalary(){return TruncateValue.toDouble(getNetSalaryInternal(), TruncationLevel);}    
    public double getNetSalaryInternal(){return getGrossSalary() - calcTax();}

    public void setGrossSalary(double newGrossSalary) throws InvalidEmployeeDataException {
        if (newGrossSalary <= 0){
            throw new InvalidEmployeeDataException("Salary must be greater than zero.");
        } else{
        initialSalary = newGrossSalary;
        }
    }


    public void setName(String newName) throws InvalidEmployeeDataException {
        if (newName.trim().isEmpty()){
            throw new InvalidEmployeeDataException("Name cannot be blank.");
        } else {
        this.name = newName;
        }
    }

    public double calcTax(){
        double gross = getGrossSalary();
        if (!(this instanceof Director)){
            if (this instanceof Intern){
                return 0;
            } else {
                return (gross)*standardTax;
            }
        } else {
            if (gross > highTaxBracket){
                return (lowTaxBracket * middleTax) + (gross - lowTaxBracket)*highTax;
            } else if (gross >= lowTaxBracket){
                return (gross * middleTax);
            } else{
                return (gross) * standardTax;
            }

        }
    }
    public double calcSalary(){
        double bonus = 0;
        double initSalary = getInitialSalary();
        String degree = "";
        System.out.println(initSalary);
        if ((this instanceof Director)||(this instanceof Manager)){
            
            if (this instanceof Manager){
                 degree = ((Manager)this).getDegree();
            } else {
                 degree = ((Director)this).getDegree();
            } if (degree.equals("BSc")){
                bonus = initSalary * BScMultiplier;
            }
            else if (degree.equals("MSc")){
                bonus = initSalary * MScMultiplier;
            }
            else if (degree.equals("PhD")){
                bonus = initSalary * PhDMultiplier;
            }
            if (this instanceof Director){
                bonus += directorBonus;
            }
        } else if (this instanceof Intern){
            int GPA = ((Intern) this).getGPA();
            if (GPA >= 8){
                bonus = studentBonus;
            } else if ((GPA > 5) && (GPA < 8)){
                bonus = 0;
            } else {
                bonus = -initSalary;
            }
        }
        System.out.println(bonus);
        return bonus;
    }

    public String toString(){
        return String.format("%s's gross salary is %.2f SEK per month.", name, getGrossSalary());
    }
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        } 
        else if (obj == null || obj instanceof Employee){
            return false;
        }
        Employee otherEmployee = (Employee) obj;
        return this.employeeID.equals(otherEmployee.employeeID);
    }

    
    
}