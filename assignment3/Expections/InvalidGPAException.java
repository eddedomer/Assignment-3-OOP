package assignment3.Expections;

public class InvalidGPAException extends Exception {
    public InvalidGPAException(int GPA){
        super(GPA + " outside range. Must be between 0-10.");
    }
}