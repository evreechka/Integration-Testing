package functions;

import java.util.function.Function;

public class LogarithmModule implements Function<Double, Double> {

    private final NaturalLogarithmModule LN;
    private final double BASE;

    public LogarithmModule(NaturalLogarithmModule ln, double base) {
        LN = ln;
        BASE = base;
    }

    @Override
    public Double apply(Double x) {
        return LN.apply(x) / LN.apply(BASE);
    }
}
