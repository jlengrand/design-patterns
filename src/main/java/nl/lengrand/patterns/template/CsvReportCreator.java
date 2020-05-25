package nl.lengrand.patterns.template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class extends from the template report creator, only implementing the logic to read a csv file
 * as input for a report
 */
public class CsvReportCreator extends ReportCreator {

    @Override
    protected List<Integer> readValuesFromInput(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] values = br.readLine().split(",");
            return Arrays.stream(values)
                    .map(v -> v.trim())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
    }
}
