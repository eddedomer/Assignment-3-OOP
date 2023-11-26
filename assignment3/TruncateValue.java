package assignment3;

public class TruncateValue {

    //trunates the value to the "truncateTo" decimal place. 
    public static double truncateToDouble(double value, int truncateTo) {
        double exponent = powerBase10(truncateTo);

        return (int) (value * exponent) / exponent;
    }

    //if the user makes the the truncatoTo less than or equal to 0. 1 is returned. ensuring all decimalplaces are removed. 
    public static double powerBase10 (int exponent) {
        double result;
        int base = 10;

        if (exponent > 0) {
            result = base;

            for (int i = 1; i < exponent; i++) {
                result *= base;
            }
        } else {
            result = 1;
        }

        return result;
    }
}
