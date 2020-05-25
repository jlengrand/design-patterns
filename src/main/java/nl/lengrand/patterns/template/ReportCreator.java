package nl.lengrand.patterns.template;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ReportCreator {

    final void createReport(File filePath) throws IOException {
        List<Integer> values = readValuesFromInput(filePath);
        checkValues(values);
        printValues(values);
    }

    private void printValues(List<Integer> values) {
        System.out.println("=================");
        System.out.println("Values are:");
        System.out.println(values.stream()
                .map(v -> v.toString())
                .collect(Collectors.joining(",")));
        System.out.println("End of report");
        System.out.println("=================");
    }

    protected abstract List<Integer> readValuesFromInput(File file) throws IOException;

    private void checkValues(List<Integer> values){
        if(values == null || values.stream().anyMatch( v -> v < 0)){
            throw new InputMismatchException("Expecting all values to be positive");
        }
    }
}
