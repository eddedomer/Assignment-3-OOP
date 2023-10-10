package assignment3;

public class Intern extends Employee {
    private int GPA;

    public Intern(String employeeID, String name, double grossSalary, int GPA) {
        super(employeeID, name, grossSalary);
        this.GPA = GPA;
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int newGPA) {
        this.GPA = newGPA;
    }
    @Override
    public String toString(){
        return String.format("%s's gross salary is %.2f SEK per month. GPA: %s", getName(), getGrossSalary(), GPA);
    }
}
