package Lessons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadBinaryFile {
    public static void main(String[] args) {
        File file = new File("test.txt");

        try (FileInputStream fis = new FileInputStream(file)) {

            int content;
            while ((content = fis.read()) != -1) {
                System.out.println((char) content);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
