package level1;

public class NullPointerExceptionDemo {

    public static void main(String[] args) {
        System.out.println("Generating NullPointerException");
        // generateException();  // Uncomment to see the exception

        System.out.println("Handling NullPointerException ===");
        handleException();
    }

    private static void generateException() {
        String text = null;
        System.out.println("Length of text: " + text.length());
    }

    private static void handleException() {
        String text = null;
        try {
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
            System.out.println("The string is null, cannot access its methods.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
}
