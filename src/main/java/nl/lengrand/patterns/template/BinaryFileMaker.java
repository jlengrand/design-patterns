package nl.lengrand.patterns.template;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * This file was just created to created the binary report that will be later read.
 * It is not part of the template method pattern
 */
public class BinaryFileMaker {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/main/resources/template.bin");
        byte[] bytes = "123456".getBytes(StandardCharsets.UTF_8);

        Files.write(path, bytes);
        System.out.println("Successfully written data to the file");
    }
}
