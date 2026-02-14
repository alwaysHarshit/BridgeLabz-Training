import java.util.Scanner;

public class ArrayOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;

        try {

            System.out.print("Enter index to retrieve: ");
            int index = scanner.nextInt();

            int value = array[index];
            System.out.println("Value at index " + index + ": " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");

        } finally {
            scanner.close();
        }
    }
}
