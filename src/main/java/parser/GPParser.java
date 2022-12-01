package parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GPParser {
    private static String Header;

    public static void createFile(String fileName, String filepath) throws IOException {
        try {
            File robotFile = new File(filepath + fileName + ".java");
            if (robotFile.createNewFile()) {
                System.out.println("Robot file created: " + robotFile.getName());
            } else {
                System.out.println("Robot file already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String input, String fileName, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath + fileName + ".java");

            Header="package sample;\r\n" +  "\r\n" +  "import robocode.*;" + "\r\n\n";
            writer.write(Header);
            writer.write(input);
            writer.close();

            System.out.println("Successfully written to the Robot file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void deleteFile(String fileName) throws IOException {
        File fileToDelete = new File("src/main/java/sample/" + fileName + ".java");
        if (fileToDelete.delete()) {
            System.out.println("Deleted the file: " + fileToDelete.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

        File fileToDelete2 = new File("robots/sample/" + fileName + ".java");
        if (fileToDelete2.delete()) {
            System.out.println("Deleted the file: " + fileToDelete2.getName());
        } else {
            System.out.println("Failed to delete the file 2.");
        }
    }

    public static void renameRobotClass(String oldName, String newName) throws IOException {
        Map<String, String> replaceMap = new HashMap<String, String>();
        replaceMap.put(oldName, newName);

        Path path = Paths.get("D:\\Škola\\FEKT\\MPC-IBE1\\PDA\\Projekt\\PDA-project\\src\\main\\java\\sampleEnderTank.java");
        Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
        List<String> replacedLines = lines.map(line -> replaceTag(line, replaceMap))
                .collect(Collectors.toList());
        Files.write(path, replacedLines, StandardCharsets.UTF_8);
    }

    private static String replaceTag(String str, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.contains(entry.getKey())) {
                str = str.replace(entry.getKey(), entry.getValue());
            }
        }
        return str;
    }
}
