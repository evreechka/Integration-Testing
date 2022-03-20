import functions.LogarithmModule;
import functions.SinModule;

import java.util.function.Function;

public class FunctionSystem implements Function<Double, Double> {
    private final LogarithmModule LOG_3;
    private final LogarithmModule LOG_5;
    private final LogarithmModule LOG_10;
    private final SinModule SIN;

    public FunctionSystem(LogarithmModule log_3, LogarithmModule log_5, LogarithmModule log_10, SinModule sin) {
        LOG_3 = log_3;
        LOG_5 = log_5;
        LOG_10 = log_10;
        SIN = sin;
    }

    @Override
    public Double apply(Double x) {
        if (x <= 0) {
            return 1 / SIN.apply(x);
        } else
            return Math.pow(((((LOG_3.apply(x) * LOG_3.apply(x))
                    * (LOG_10.apply(x) - LOG_5.apply(x)))
                    + LOG_5.apply(x)) * (LOG_10.apply(x)
                    * LOG_10.apply(x))), 3);
    }
}
