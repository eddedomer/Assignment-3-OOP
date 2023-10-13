package assignment3;

public class TruncateValue {

    //trunates the value to the "truncateTo" decimal place. 
    public static double toDouble(double value, int truncateTo) {
        double exponent = power(10, truncateTo);

        return (int) (value * exponent) / exponent;
    }

    //Our own version of the math.pow. 
    public static double power(int number, int exponent) {
        double result;

        if (exponent > 0) {
            result = number;

            for (int i = 1; i < exponent; i++) {
                result *= number;
            }
        } else if (exponent == 0) {
            result = 1;
        } else {
            result = number / number;

            for (int i = 0; i > exponent; i--) {
                result /= number;
            }
        }

        return result;
    }
}
