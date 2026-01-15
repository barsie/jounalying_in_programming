package Lessons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFile {
    public static void main(String[] args) {
        File file = new File("test.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
           bw.write("Thsi is not nothin");
           bw.newLine();
           bw.write("This is not nothin"); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
