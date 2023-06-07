import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilePrinter {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "C:\\Users\\User\\eclipse-workspace\\fourthwebsiteattempt\\src\\main\\WebContent\\index.html";
        File file = new File(filePath);
        printFileContents(file);
    }

    public static void printFileContents(File file) throws FileNotFoundException {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
