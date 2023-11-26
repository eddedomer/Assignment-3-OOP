package assignment3;

import assignment3.Expections.InvalidEmployeeDataException;

public class Manager extends Employee {
    private String degree;

    private final String EXCEP_MESSAGE = "Degree must be one of the options: BSc, MSc or PhD.";

    public Manager(String employeeID, String name, double grossSalary, String degree) throws InvalidEmployeeDataException {
        super(employeeID, name, grossSalary);
        //if the degree is incorrect.
        if ((!degree.equals(BSC_TERM) && !degree.equals(MSC_TERM) && !degree.equals(PHD_TERM))) {
            throw new InvalidEmployeeDataException(EXCEP_MESSAGE);
        } else {
            this.degree = degree;
        }
    }

    public String getDegree() { return degree; }

    @Override
    public double getGrossSalary() { 
        double bonus = 0;
            String degree = getDegree();

            if (degree.equals(BSC_TERM)) {
                bonus = getInitialSalary() * BSC_MULTIPLIER;
            } else if (degree.equals(MSC_TERM)) {
                bonus = getInitialSalary() * MSC_MULTIPLIER;
            } else if (degree.equals(PHD_TERM)) {
                bonus = getInitialSalary() * PHD_MULTIPLIER;
            }
        return TruncateValue.truncateToDouble(getInitialSalary() + bonus, TRUNCATION_LEVEL);
    }

    public void setDegree(String newDegree) throws InvalidEmployeeDataException {
        if (!newDegree.equals(BSC_TERM) && !newDegree.equals(MSC_TERM) && !newDegree.equals(PHD_TERM)) {
            throw new InvalidEmployeeDataException(EXCEP_MESSAGE);
        } else {
            this.degree = newDegree;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s's gross salary is %.2f SEK per month.", degree, getName(), getGrossSalary());
    }

}
