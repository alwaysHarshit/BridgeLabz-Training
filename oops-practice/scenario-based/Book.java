package scenariobased;

public class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkOut() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException(
                String.format("'%s' is currently checked out and unavailable", title)
            );
        }
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        String status = isAvailable ? "✓ Available" : "✗ Checked Out";
        return String.format("%-35s | %-20s | %s", title, author, status);
    }
}
