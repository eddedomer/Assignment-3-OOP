package assignment3.Expections;

public class RepeatedIDException extends Exception {

    public RepeatedIDException(String employeeID){
        super("Cannot register. ID "+ employeeID + " is already registered.");
    }
    public RepeatedIDException(){
        super();
    }
    
}
