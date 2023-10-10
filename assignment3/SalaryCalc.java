package assignment3;
public class SalaryCalc{

    private double salaryBonus;
    private double netSalary;

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

    public SalaryCalc(Employee emp){
        this.salaryBonus = calcSalary(emp);
        this.netSalary = (emp.getInitialSalary() + salaryBonus) - calcTax(emp);
    }
    public double getNetSalary() { return netSalary; }
    public double getSalaryBonus() { return salaryBonus; }

    public double calcSalary(Employee emp){
        double bonus = 0;
        double initSalary = emp.getInitialSalary();
        System.out.println(initSalary);
        if ((emp instanceof Director)||(emp instanceof Manager)){
            String degree = ((Manager) emp).getDegree();
            System.out.println(degree);
            if (degree.equals("BSc")){
                bonus = initSalary * BScMultiplier;
            }
            else if (degree.equals("MSc")){
                bonus = initSalary * MScMultiplier;
            }
            else if (degree.equals("PhD")){
                bonus = initSalary * PhDMultiplier;
            }
            if (emp instanceof Director){
                bonus += directorBonus;
            }
        } else if (emp instanceof Intern){
            int GPA = ((Intern) emp).getGPA();
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
    public double calcTax(Employee emp){
        double gross = emp.getInitialSalary() + salaryBonus;
        if (!(emp instanceof Director)){
            return (gross)*standardTax;
        } else {
            if (gross > highTaxBracket){
                return (lowTaxBracket * middleTax) + (gross - lowTaxBracket)*highTax;
            } else if (gross >= lowTaxBracket){
                return (gross * middleTax);
            } else{
                return (gross)*standardTax;
            }

        }
    }
}