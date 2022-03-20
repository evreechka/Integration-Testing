package utils;

public class FunctionUtils {
    public static final int ITERATION_COUNT = 256;

    public static double factorial(int x) {
        double result;
        if (x == 0) {
            return 1.0;
        } else {
            result = x * factorial(x - 1);
        }
        return result;
    }
}
