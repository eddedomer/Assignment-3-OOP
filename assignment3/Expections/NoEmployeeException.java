package assignment3.Expections;

public class NoEmployeeException extends Exception {

    public NoEmployeeException(){
        super("No employees registered yet.");
    }
    public NoEmployeeException(String message){
        super(message);
    }
    
}