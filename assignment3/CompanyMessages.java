package assignment3;

public class CompanyMessages {
    public static String creationSuccessfull(String employeeID){
        return String.format("Employee %s was registered successfully.",employeeID);
    }
    public static String updateSuccessfull(String employeeID){
        return String.format("Employee %s was updated successfully",employeeID);
    }
}
