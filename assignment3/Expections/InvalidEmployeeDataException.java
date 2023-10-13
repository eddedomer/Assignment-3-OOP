package assignment3.Expections;

public class InvalidEmployeeDataException extends Exception {
    public InvalidEmployeeDataException(String message) {
        super(message);
    }
    public InvalidEmployeeDataException(int invalidGPA) {
        super(invalidGPA + " outside range. Must be between 0-10.");
    }
}