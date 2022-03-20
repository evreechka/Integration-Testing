package functions;

import utils.FunctionUtils;

import java.util.function.Function;

public class SinModule implements Function<Double, Double> {
    @Override
    public Double apply(Double x) {
        double result = 0;
        for (int i = 1; i <= FunctionUtils.ITERATION_COUNT; i++) {
            result += Math.pow(-1, i - 1) * (Math.pow(x, 2 * i - 1)) / FunctionUtils.factorial(2 * i - 1);
        }
        return result;
    }
}
