package nl.lengrand.patterns.template;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinReportCreator extends ReportCreator{

    @Override
    protected List<Integer> readValuesFromInput(File file) throws IOException {
        String valuesAsString = new String(Files.readAllBytes(file.toPath()), StandardCharsets.US_ASCII);

        return Arrays.stream(valuesAsString.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
