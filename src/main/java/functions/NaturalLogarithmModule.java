package functions;

import utils.FunctionUtils;

import java.util.function.Function;

public class NaturalLogarithmModule implements Function<Double, Double> {
    private final double a;

    public NaturalLogarithmModule(double a) {
        this.a = a;
    }

    @Override
    public Double apply(Double x) {
        double result = Math.log(a);
        for (int i = 1; i <= FunctionUtils.ITERATION_COUNT; i++) {
            result += Math.pow(-1, i - 1) * Math.pow(x - a, i) / (i * Math.pow(a, i));
        }
        return result;
    }
}
