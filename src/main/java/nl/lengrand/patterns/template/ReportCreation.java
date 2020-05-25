package nl.lengrand.patterns.template;

import java.io.File;
import java.io.IOException;

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
