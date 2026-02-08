import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LibraryBookStatistics {

    public static void displayBookStatistics(List<Book> books){
        Map<Genre, IntSummaryStatistics> statistics = books.stream()
                                                            .collect(Collectors.groupingBy(book -> book.genre ,
                                                                Collectors.summarizingInt(book -> book.numberOfPages)));

        for(Map.Entry<Genre, IntSummaryStatistics> entry: statistics.entrySet()){
            IntSummaryStatistics summary = entry.getValue();
            System.out.printf("Genre: %s, Total pages: %d, Average Pages: %d, Maximum Pages: %d%n", entry.getKey(), summary.getSum(), (int)summary.getAverage(), summary.getMax());
        }
    }
    
    public static void main(String[] args) {
        
        List<Book> books = new ArrayList<>();

        books.add(new Book("B123", "Carol", Genre.ROMANCE, 1250));
        books.add(new Book("B456", "Alice in wonderland", Genre.FANTASY, 1570));
        books.add(new Book("B789", "Dune", Genre.SCIFI, 1874));
        books.add(new Book("B147", "Game of Thrones", Genre.FANTASY, 1346));
        books.add(new Book("B258", "The Silent Patient", Genre.MYSTERY, 842));
        books.add(new Book("B369", "Carrie", Genre.HORROR, 789));
        books.add(new Book("B159", "Pride and Prejudice", Genre.ROMANCE, 1626));
        books.add(new Book("B753", "Human Centipede", Genre.HORROR, 950));
        books.add(new Book("B268", "All the Light We Cannot See", Genre.HISTORICAL, 2410));
        books.add(new Book("B842", "Adventures of Tinker Bell", Genre.FANTASY, 754));
        books.add(new Book("B170", "In Cold Blood", Genre.MYSTERY, 1462));

        displayBookStatistics(books);
    }
}

enum Genre{
    ROMANCE, HORROR, HISTORICAL, FANTASY, SCIFI, MYSTERY;
}

class Book{

    protected final String id;
    protected String title;
    protected Genre genre;
    protected int numberOfPages;

    public Book(String id, String title, Genre genre, int numberOfPages) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }
    
}