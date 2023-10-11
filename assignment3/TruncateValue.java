package assignment3;

public class TruncateValue {
    //trunkerar en double till "truncateTo" numret man ger. 2 = 2 decimaler. 0 = 0 decimaler etc...
    public static double toDouble(double value, int truncateTo){
        double exponent = exponentPower(10, truncateTo);

        return (int) (value * exponent) / exponent;
    }
    //castar double to int (lite onödig)
    public static int toInt(double Value){
        return (int)(Value);
    }

    //en egen Math.Pow(int numret, int exponent)
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
