package arrangement;

import java.util.Scanner;

public class DigitalLibraryKiosk {
    public static void main(String[] args) {
        SmartShelf shelf = new SmartShelf();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Digital Library Kiosk - SmartShelf");

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add a book to reading list");
            System.out.println("2. View reading list");
            System.out.println("3. Exit kiosk");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addBookInteractive(scanner, shelf);
                    break;

                case "2":
                    shelf.displayReadingList();
                    break;

                case "3":
                    System.out.println("\nThanks for using SmartShelf! Happy reading! 📖");
                    keepRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private static void addBookInteractive(Scanner scanner, SmartShelf shelf) {
        System.out.println("\n--- Add New Book ---");

        System.out.print("Book title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Title cannot be empty. Book not added.");
            return;
        }

        System.out.print("Author name: ");
        String author = scanner.nextLine().trim();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine().trim();

        Book book = new Book(title, author.isEmpty() ? "Unknown" : author,
                            isbn.isEmpty() ? "N/A" : isbn);
        shelf.addBook(book);
    }
}
