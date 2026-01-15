package Lessons;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinaryFile {
   public static void main(String[] args) {
    File file = new File("test.bin");

    try (FileOutputStream fos = new FileOutputStream(file)) {
        String content = "Social things are not things";
        fos.write(content.getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }
   } 
}
