package java.Streams;
import java.io.*;

public class ByteArrayStream {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("image.jpg");
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            byte[] imageBytes = baos.toByteArray();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream("copied_image.jpg")) {

                while ((len = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }

                System.out.println("Image copied via byte array.");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
