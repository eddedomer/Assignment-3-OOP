package assignment3;

import assignment3.Expections.InvalidEmployeeDataException;

public class Intern extends Employee {
    private int GPA;

    private final int MAX_GPA = 10;
    private final int MIN_GPA = 0;

    public Intern(String employeeID, String name, double grossSalary, int GPA)throws InvalidEmployeeDataException {
        super(employeeID, name, grossSalary);
        if ((GPA < MIN_GPA) || (GPA > MAX_GPA)){
            throw new InvalidEmployeeDataException(GPA);
        } else {
            this.GPA = GPA;
        }
    }

    public int getGPA() { return GPA; }

    public void setGPA(int newGPA) throws InvalidEmployeeDataException {
        if ((newGPA < MIN_GPA) || (newGPA > MAX_GPA)){
            throw new InvalidEmployeeDataException(newGPA);
        } else {
            this.GPA = newGPA;
        }
    }

    @Override
    public String toString(){
        return String.format("%s's gross salary is %.2f SEK per month. GPA: %s", getName(), getGrossSalary(), GPA);
    }
}
