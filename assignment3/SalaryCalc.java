package assignment3;
public class SalaryCalc{

    private double salaryBonus;
    private double netSalary;

    final double BScMultiplier = 0.1;
    final double MScMultiplier = 0.2;
    final double PhDMultiplier = 0.35;

    public SalaryCalc(Employee emp){
        this.salaryBonus = calcSalary(emp);
        this.netSalary = (emp.getGrossSalary() + salaryBonus)* 0.9;
    }
    
    public double calcSalary(Employee emp){
        if (emp instanceof Manager){
            String degree = ((Manager)emp).getDegree();
            if (degree == "BSc"){
                return emp.getGrossSalary() * BScMultiplier;
            }
            else if (degree == "MSc"){
                return emp.getGrossSalary() * MScMultiplier;
            }
            else if (degree == "PhD"){
                return emp.getGrossSalary() * PhDMultiplier;
            }
        } else if (emp instanceof Director){

        } else if (emp instanceof intern){
            
        }
        return 0;
    }
}