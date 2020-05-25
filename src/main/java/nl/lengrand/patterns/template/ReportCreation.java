package nl.lengrand.patterns.template;

import java.io.File;
import java.io.IOException;


/**
 * This class is here to demonstrate how to use the template method pattern.
 * Below, we are creating reports from a csv and a binary file.
 * Only a small part of the implementation is available to us, which allows to hide the complexity in a neat way.
 *
 * There is some boilerplate needed to find the files in the resource folder, but you can ignore that part
 *
 * The file being used to generate reports are in the resource folder, named template.csv and template.bin
 */
public class ReportCreation {
    public static void main(String[] args) throws IOException {
        ReportCreation reportCreation = new ReportCreation();
        File csvFile = reportCreation.getFileFromName("template.csv");
        File binFile = reportCreation.getFileFromName("template.bin");

        System.out.println("Creating report from CSV file");
        CsvReportCreator csvReportCreator = new CsvReportCreator();
        csvReportCreator.createReport(csvFile);

        System.out.println("Creating report from binary file");
        BinReportCreator binReportCreator = new BinReportCreator();
        binReportCreator.createReport(binFile);

        System.out.println("Done");
    }

    private File getFileFromName(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }
}
