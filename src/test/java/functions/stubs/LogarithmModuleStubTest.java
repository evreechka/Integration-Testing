package functions.stubs;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import functions.LogarithmModule;
import functions.NaturalLogarithmModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LogarithmModuleStubTest {
    public static final NaturalLogarithmModule lnStub = mock(NaturalLogarithmModule.class);
    public static LogarithmModule log_3Stub = mock(LogarithmModule.class);
    public static LogarithmModule log_5Stub = mock(LogarithmModule.class);
    public static LogarithmModule log_10Stub = mock(LogarithmModule.class);
    public static final double ACCURACY = 0.02;
    @BeforeAll
    public static void setUp() throws IOException, CsvException {
        fillMock(lnStub, "src/test/resources/log/ln_table.csv");
        fillMock(log_3Stub, "src/test/resources/log/log3_table.csv");
        fillMock(log_5Stub, "src/test/resources/log/log5_table.csv");
        fillMock(log_10Stub, "src/test/resources/log/log10_table.csv");
    }
    private static void fillMock(Function<Double, Double> module, String tableName) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader(tableName))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                final double x = Double.parseDouble(record[0]);
                final double y = Double.parseDouble(record[1]);
                when(module.apply(x)).thenReturn(y);
            }
        }
    }
    @ParameterizedTest
    @CsvFileSource(resources = {"/log/log3_table.csv"})
    public void log_3PositiveValuesTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, log_3Stub.apply(x), ACCURACY);
    }
    @ParameterizedTest
    @CsvFileSource(resources = {"/log/log5_table.csv"})
    public void log_5PositiveValuesTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, log_5Stub.apply(x), ACCURACY);
    }
    @ParameterizedTest
    @CsvFileSource(resources = {"/log/log10_table.csv"})
    public void log_10PositiveValuesTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, log_10Stub.apply(x), ACCURACY);
    }
}
