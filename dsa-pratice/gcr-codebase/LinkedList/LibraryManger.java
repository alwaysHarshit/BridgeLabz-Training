package com.Linkedlist;
import java.util.Scanner;

class Book {
    String title, author, genre;
    int bookId;
    boolean isAvailable;
    Book prev, next;

    Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}

class Library {
    Book head = null, tail = null;

    void addFirst(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    void addLast(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    void addAtPosition(int pos, String title, String author, String genre, int id, boolean available) {
        if (pos == 0) {
            addFirst(title, author, genre, id, available);
            return;
        }

        Book curr = head;
        for (int i = 1; i < pos && curr != null; i++) {
            curr = curr.next;
        }

        if (curr != null) {
            Book newBook = new Book(title, author, genre, id, available);
            newBook.next = curr.next;
            newBook.prev = curr;
            if (curr.next != null) curr.next.prev = newBook;
            curr.next = newBook;
            if (newBook.next == null) tail = newBook;
        }
    }

    void removeById(int id) {
        Book curr = head;
        while (curr != null) {
            if (curr.bookId == id) {
                if (curr.prev != null) curr.prev.next = curr.next;
                else head = curr.next;

                if (curr.next != null) curr.next.prev = curr.prev;
                else tail = curr.prev;

                System.out.println("Book removed.");
                return;
            }
            curr = curr.next;
        }
        System.out.println("Book not found.");
    }

    void searchByTitleOrAuthor(String key) {
        Book curr = head;
        boolean found = false;
        while (curr != null) {
            if (curr.title.equalsIgnoreCase(key) || curr.author.equalsIgnoreCase(key)) {
                System.out.println("Title: " + curr.title + " | Author: " + curr.author + " | Genre: " + curr.genre +
                        " | ID: " + curr.bookId + " | Available: " + curr.isAvailable);
                found = true;
            }
            curr = curr.next;
        }
        if (!found) System.out.println("No matching books found.");
    }

    void updateAvailability(int id, boolean status) {
        Book curr = head;
        while (curr != null) {
            if (curr.bookId == id) {
                curr.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            curr = curr.next;
        }
        System.out.println("Book not found.");
    }

    void displayForward() {
        if (head == null) {
            System.out.println("No books in library.");
            return;
        }

        System.out.println("\nBooks (Forward):");
        Book curr = head;
        while (curr != null) {
            System.out.println("Title: " + curr.title + ", Author: " + curr.author + ", Genre: " + curr.genre +
                    ", ID: " + curr.bookId + ", Available: " + curr.isAvailable);
            curr = curr.next;
        }
    }

    void displayBackward() {
        if (tail == null) {
            System.out.println("No books in library.");
            return;
        }

        System.out.println("\nBooks (Reverse):");
        Book curr = tail;
        while (curr != null) {
            System.out.println("Title: " + curr.title + ", Author: " + curr.author + ", Genre: " + curr.genre +
                    ", ID: " + curr.bookId + ", Available: " + curr.isAvailable);
            curr = curr.prev;
        }
    }

    void countBooks() {
        int count = 0;
        Book curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        System.out.println("Total number of books: " + count);
    }
}

public class LibraryManger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title/Author");
            System.out.println("6. Update Book Availability");
            System.out.println("7. Display All Books (Forward)");
            System.out.println("8. Display All Books (Reverse)");
            System.out.println("9. Count Total Books");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            int id, pos;
            String title, author, genre, key;
            boolean status;

            switch (ch) {
                case 1:
                    sc.nextLine();
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Author: ");
                    author = sc.nextLine();
                    System.out.print("Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Book ID: ");
                    id = sc.nextInt();
                    System.out.print("Is Available (true/false): ");
                    status = sc.nextBoolean();
                    library.addFirst(title, author, genre, id, status);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Author: ");
                    author = sc.nextLine();
                    System.out.print("Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Book ID: ");
                    id = sc.nextInt();
                    System.out.print("Is Available (true/false): ");
                    status = sc.nextBoolean();
                    library.addLast(title, author, genre, id, status);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Author: ");
                    author = sc.nextLine();
                    System.out.print("Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Book ID: ");
                    id = sc.nextInt();
                    System.out.print("Is Available (true/false): ");
                    status = sc.nextBoolean();
                    library.addAtPosition(pos, title, author, genre, id, status);
                    break;

                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    id = sc.nextInt();
                    library.removeById(id);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Enter Title or Author to search: ");
                    key = sc.nextLine();
                    library.searchByTitleOrAuthor(key);
                    break;

                case 6:
                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter new availability (true/false): ");
                    status = sc.nextBoolean();
                    library.updateAvailability(id, status);
                    break;

                case 7:
                    library.displayForward();
                    break;

                case 8:
                    library.displayBackward();
                    break;

                case 9:
                    library.countBooks();
                    break;

                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}


