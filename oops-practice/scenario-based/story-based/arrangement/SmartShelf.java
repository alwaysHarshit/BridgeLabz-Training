package arrangement;

import java.util.ArrayList;
import java.util.List;

public class SmartShelf {
    private List<Book> readingList;

    public SmartShelf() {
        this.readingList = new ArrayList<>();
    }

    // Real-time insertion with sorting using Insertion Sort
    public void addBook(Book newBook) {
        readingList.add(newBook);

        int currentIndex = readingList.size() - 1;

        // Insertion Sort logic - shift books to maintain alphabetical order
        while (currentIndex > 0 &&
               readingList.get(currentIndex - 1).getTitle().compareToIgnoreCase(newBook.getTitle()) > 0) {
            readingList.set(currentIndex, readingList.get(currentIndex - 1));
            currentIndex--;
        }

        readingList.set(currentIndex, newBook);

        System.out.printf("✓ Added '%s' to your reading list (position %d)\n",
                         newBook.getTitle(), currentIndex + 1);
    }

    public void displayReadingList() {
        if (readingList.isEmpty()) {
            System.out.println("Your reading list is empty. Time to discover some books!");
            return;
        }

        System.out.println("\n📚 Your Reading List (Alphabetically Sorted):");
        System.out.println("─────────────────────────────────────────────");

        int position = 1;
        for (Book book : readingList) {
            System.out.printf("%2d. %s\n", position++, book);
        }
        System.out.println();
    }

    public int getBookCount() {
        return readingList.size();
    }

    public boolean isEmpty() {
        return readingList.isEmpty();
    }
}
