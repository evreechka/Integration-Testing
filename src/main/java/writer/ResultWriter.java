package writer;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class ResultWriter {
    private final Function<Double, Double> module;
    private final String FILE_NAME;

    public ResultWriter(Function<Double, Double> module, String file_name) {
        this.module = module;
        FILE_NAME = file_name;
    }

    public boolean write(Double x) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(FILE_NAME))) {
            String[] record = new String[]{Double.toString(x), Double.toString(module.apply(x))};
            writer.writeNext(record);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
