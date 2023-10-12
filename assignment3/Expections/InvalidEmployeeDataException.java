package assignment3.Expections;

public class InvalidEmployeeDataException extends Exception {
    public InvalidEmployeeDataException(String message) {
        super(message);
    }
}