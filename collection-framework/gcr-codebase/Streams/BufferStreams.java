package java.Streams;
import java.io.*;

public class BufferStreams {
    public static void main(String[] args) {
        File input = new File("largefile.txt");
        File output = new File("copyfile.txt");

        long start = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(input));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(output))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("Buffered copy time: " + (end - start) / 1_000_000 + " ms");
    }
}
