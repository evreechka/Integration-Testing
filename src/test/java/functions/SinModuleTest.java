package functions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import writer.ResultWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinModuleTest {
    public static final SinModule sin = new SinModule();
    private static final ResultWriter writer = new ResultWriter(sin, "src/test/resources/results/sin.csv");
    public static final double ACCURACY = 0.2;
    @ParameterizedTest
    @CsvFileSource(resources = {"/trigonometric/sin_table.csv"})
    public void sinNegativeValuesTest(Double x, Double expectedResult) {
        writer.write(x);
        assertEquals(expectedResult, sin.apply(x), ACCURACY);
    }
}
