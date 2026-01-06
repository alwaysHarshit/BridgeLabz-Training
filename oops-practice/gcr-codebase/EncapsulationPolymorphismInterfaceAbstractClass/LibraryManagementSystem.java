import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    abstract int getLoanDuration();

    String getItemDetails() {
        return "Item ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }
}

class Book extends LibraryItem {
    Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    int getLoanDuration() {
        return 14; // Books can be loaned for 14 days
    }
}

class Magazine extends LibraryItem {
    Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    int getLoanDuration() {
        return 7; // Magazines can be loaned for 7 days
    }
}

class DVD extends LibraryItem {
    DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    int getLoanDuration() {
        return 3; // DVDs can be loaned for 3 days
    }
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        items.add(new Magazine(2, "National Geographic", "Various"));
        items.add(new DVD(3, "Inception", "Christopher Nolan"));

        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails() + ", Loan Duration: " + item.getLoanDuration() + " days");
        }
    }
}