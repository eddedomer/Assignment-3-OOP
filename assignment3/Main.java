package assignment3;

public class Main {
    public static void main(String[] args) {
        Employee anna = new Intern("An1", "Anna", 15000, 9);
        System.out.println(anna);
        System.out.println(anna.getGrossSalary());
    }
}
