package parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

            Header="package sample;\r\n" +  "\r\n" +  "import robocode.*;" + "\r\n\n" + "public class " + fileName + " extends Robot {\n";
            writer.write(Header);
            writer.write(input);
            writer.write("}");
            writer.close();

            System.out.println("Successfully wrote to the Robot file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void deleteFile(String fileName) throws IOException {
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
}
