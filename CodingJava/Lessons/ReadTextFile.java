package Lessons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
    public static void main(String[] args) {
      File file = new File("test.txt");
      
      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
          System.out.println(line);  
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}
