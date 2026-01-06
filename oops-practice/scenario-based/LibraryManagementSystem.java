package scenariobased;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private List<Book> library;

    public LibraryManagementSystem() {
        this.library = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        library.add(newBook);
        System.out.println("Book added to library!");
    }

    public void searchByTitle(String query) {
        List<Book> results = new ArrayList<>();

        for (Book book : library) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }

        displaySearchResults(results, query);
    }

    public void displayAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Library catalog is empty.");
            return;
        }

        System.out.println("\n📚 Library Catalog:");
        System.out.println("═".repeat(80));
        System.out.printf("%-35s | %-20s | %s%n", "Title", "Author", "Status");
        System.out.println("─".repeat(80));

        for (Book book : library) {
            System.out.println(book);
        }
        System.out.println("═".repeat(80));
    }

    private void displaySearchResults(List<Book> results, String query) {
        if (results.isEmpty()) {
            System.out.printf("No books found matching '%s'%n", query);
            return;
        }

        System.out.printf("\n🔍 Found %d book(s) matching '%s':%n", results.size(), query);
        System.out.println("─".repeat(80));
        System.out.printf("%-35s | %-20s | %s%n", "Title", "Author", "Status");
        System.out.println("─".repeat(80));

        for (Book book : results) {
            System.out.println(book);
        }
    }

    public void checkoutBook(String title) {
        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                try {
                    book.checkOut();
                    System.out.println("✓ Book checked out successfully! Happy reading!");
                    return;
                } catch (BookNotAvailableException e) {
                    System.out.println("⚠️  " + e.getMessage());
                    return;
                }
            }
        }
        System.out.println("Book not found in library catalog.");
    }

    public void returnBook(String title) {
        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    System.out.println("This book wasn't checked out.");
                } else {
                    book.returnBook();
                    System.out.println("✓ Book returned. Thank you!");
                }
                return;
            }
        }
        System.out.println("Book not found in our records.");
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("1984", "George Orwell");
        library.addBook("Pride and Prejudice", "Jane Austen");
        library.addBook("The Catcher in the Rye", "J.D. Salinger");

        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Search Books");
            System.out.println("3. Display All Books");
            System.out.println("4. Checkout Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("What would you like to do? ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author name: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;

                case 2:
                    System.out.print("Enter search term: ");
                    String searchQuery = scanner.nextLine();
                    library.searchByTitle(searchQuery);
                    break;

                case 3:
                    library.displayAllBooks();
                    break;

                case 4:
                    System.out.print("Enter exact book title to checkout: ");
                    String checkoutTitle = scanner.nextLine();
                    library.checkoutBook(checkoutTitle);
                    break;

                case 5:
                    System.out.print("Enter exact book title to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;

                case 6:
                    System.out.println("Closing library system. Have a great day!");
                    return;

                default:
                    System.out.println("That option doesn't exist. Try again.");
            }
        }
    }
}
