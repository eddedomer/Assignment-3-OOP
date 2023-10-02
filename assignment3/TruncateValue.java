package assignment3;

public class TruncateValue {
    public static double toDouble(double Value, int truncateTo){
        return (int)(Value * exponentPower(10, truncateTo))/exponentPower(10, truncateTo);
    }public static int toInt(double Value){
        return (int)(Value);
    }
    public static double exponentPower(int number, int exponent){
        double result;
        if (exponent > 0){
            result = number;
            for(int i = 1; i < exponent; i++){
            result *= number;
            }
        } else if (exponent == 0){
            result = 1;
        } else {
            result = number / number;
            for(int i = 0; i > exponent; i--){
            result /= number;
            }
        }
    return result;
    }
}
