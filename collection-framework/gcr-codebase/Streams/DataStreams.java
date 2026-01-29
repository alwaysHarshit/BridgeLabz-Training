package java.Streams;
import java.io.*;

public class DataStreams {
    public static void main(String[] args) {
        String filename = "students.dat";

        // Writing
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(1);
            dos.writeUTF("Ankit");
            dos.writeDouble(9.2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
