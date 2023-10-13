package assignment3;

import assignment3.Expections.InvalidEmployeeDataException;

public class Intern extends Employee {
    private int GPA;

    public Intern(String employeeID, String name, double grossSalary, int GPA)throws InvalidEmployeeDataException {
        super(employeeID, name, grossSalary);
        if ((GPA < 0) || (GPA > 10)){
            throw new InvalidEmployeeDataException(GPA);
        } else {
                    this.GPA = GPA;
        }
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int newGPA) throws InvalidEmployeeDataException {
        if ((newGPA < 0) || (newGPA > 10)){
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
