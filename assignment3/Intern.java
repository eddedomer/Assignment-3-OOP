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
}
