package functions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import writer.ResultWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogarithmModuleTest {
    public static final NaturalLogarithmModule ln = new NaturalLogarithmModule(6.0);
    public static LogarithmModule log_3 = new LogarithmModule(ln, 3);
    public static LogarithmModule log_5 = new LogarithmModule(ln, 5);
    public static LogarithmModule log_10 = new LogarithmModule(ln, 10);
    private static final ResultWriter writerLog3 = new ResultWriter(log_3, "src/test/resources/results/log3.csv");
    private static final ResultWriter writerLog5 = new ResultWriter(log_5, "src/test/resources/results/log5.csv");
    private static final ResultWriter writerLog10 = new ResultWriter(log_10, "src/test/resources/results/log10.csv");
    public static final double ACCURACY = 0.4;

    @ParameterizedTest
    @CsvFileSource(resources = {"/log/log3_table.csv"})
    public void log_3PositiveValuesTest(Double x, Double expectedResult) {
        writerLog3.write(x);
        assertEquals(expectedResult, log_3.apply(x), ACCURACY);
    }
    @ParameterizedTest
    @CsvFileSource(resources = {"/log/log5_table.csv"})
    public void log_5PositiveValuesTest(Double x, Double expectedResult) {
        writerLog5.write(x);
        assertEquals(expectedResult, log_5.apply(x), ACCURACY);
    }
    @ParameterizedTest
    @CsvFileSource(resources = {"/log/log10_table.csv"})
    public void log_10PositiveValuesTest(Double x, Double expectedResult) {
        writerLog10.write(x);
        assertEquals(expectedResult, log_10.apply(x), ACCURACY);
    }
}
