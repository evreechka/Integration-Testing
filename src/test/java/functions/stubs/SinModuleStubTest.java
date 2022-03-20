package functions.stubs;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import functions.SinModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SinModuleStubTest {
    public static SinModule sinStub = mock(SinModule.class);
    public static final double ACCURACY = 0.2;

    @BeforeAll
    public static void setUp() throws IOException, CsvException {
        fillMock(sinStub, "src/test/resources/trigonometric/sin_table.csv");
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
    @CsvFileSource(resources = {"/trigonometric/sin_table.csv"})
    public void sinNegativeValuesTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, sinStub.apply(x), ACCURACY);
    }
}
