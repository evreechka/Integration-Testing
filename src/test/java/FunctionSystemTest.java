import com.opencsv.exceptions.CsvException;
import functions.stubs.LogarithmModuleStubTest;
import functions.stubs.SinModuleStubTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionSystemTest {
    public static FunctionSystem functionSystem;
    public static final double ACCURACY = 0.48;

    @ParameterizedTest
    @CsvFileSource(resources = {"/main.csv"})
    public void functionSystemCalculationTest(Double x, Double expectedValue) throws IOException, CsvException {
        LogarithmModuleStubTest.setUp();
        SinModuleStubTest.setUp();
        functionSystem = new FunctionSystem(
                LogarithmModuleStubTest.log_3Stub,
                LogarithmModuleStubTest.log_5Stub,
                LogarithmModuleStubTest.log_10Stub,
                SinModuleStubTest.sinStub);
        assertEquals(expectedValue, functionSystem.apply(x), ACCURACY);
    }
}
