package functions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import writer.ResultWriter;

import static org.junit.jupiter.api.Assertions.*;


public class NaturalLogarithmModuleTest {
    public static final NaturalLogarithmModule ln = new NaturalLogarithmModule(6.0);
    private static final ResultWriter writer = new ResultWriter(ln, "src/test/resources/results/ln.csv");
    public static final double ACCURACY = 0.385;

    @ParameterizedTest
    @CsvFileSource(resources = {"/log/ln_table.csv"})
    public void lnPositiveValuesTest(Double x, Double expectedResult) {
        writer.write(x);
        assertEquals(expectedResult, ln.apply(x), ACCURACY);
    }
}
