import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TrendingMovies {

    public static void main(String[] args) {
        MoviesManager manager = new MoviesManager();

        manager.addMovie(new Movie("MOV1", "Alice in Wonderland", 4, 2019));
        manager.addMovie(new Movie("MOV2", "Carol", 4, 2008));
        manager.addMovie(new Movie("MOV3", "Phantom", 2, 2000));
        manager.addMovie(new Movie("MOV4", "Charlie's Angels", 3, 2004));
        manager.addMovie(new Movie("MOV5", "HandMaiden", 5, 2016));
        manager.addMovie(new Movie("MOV6", "Toy Story", 2, 2012));
        manager.addMovie(new Movie("MOV7", "Penelope", 3, 2015));
        manager.addMovie(new Movie("MOV8", "Barbie", 4, 2021));
        manager.addMovie(new Movie("MOV9", "Rings", 3, 2007));
        manager.addMovie(new Movie("MOV10", "Notebook", 3, 2004));

        manager.displayTopFiveMoviesRatingWise(3);
        manager.displayTopFiveMoviesReleaseYearWise(2012);
    }
    
}

class Movie{

    protected String id;
    protected String name;
    protected int rating;
    protected int releaseYear;

    public Movie(String id, String name, int rating, int releaseYear) {
        if(id==null || id.isEmpty()){
            throw new IllegalArgumentException("Invalid movie ID");
        }
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException("Invalid movie name");
        }
        if(rating<1 || rating>5){
            throw new IllegalArgumentException("Invalid movie ratings");
        }
        if(!validateYear(releaseYear)){
            throw new IllegalArgumentException("Invalid release year");
        }

        this.id = id;
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
        
    }

    private static boolean validateYear(int year){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse("01-01-"+year, formatter);
            return true;
        } 
        catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("[Movie ID: %s, Name: %s, Rating: %d, Release year: %d]", id, name, rating, releaseYear);
    }

}

class MoviesManager{

    private final List<Movie> movies;

    public MoviesManager() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie){
        if(movie!=null && !movies.contains(movie)){
            movies.add(movie);
        }
    }

    public void displayTopFiveMoviesRatingWise(int rating){

        if(rating<1 || rating>5){
            throw new IllegalArgumentException("Invalid movie ratings");
        }

        List<Movie> top5Movies = movies.stream()
                                    .filter(movie -> movie.rating>=rating)
                                    .sorted(Comparator.comparingInt((Movie movie)->movie.rating).reversed())
                                    .limit(5)
                                    .collect(Collectors.toList());

        if(top5Movies.isEmpty()){
            System.out.println("No movies found.");
            return;
        }

        System.out.println("Top movies (rating-wise): ");
        for(Movie movie: top5Movies){
            System.out.println(movie);
        }
    }

    public void displayTopFiveMoviesReleaseYearWise(int year){
        if(!validateYear(year)){
            throw new IllegalArgumentException("Invalid year");
        }

        List<Movie> top5Movies = movies.stream()
                                    .filter(movie -> movie.releaseYear>=year)
                                    .sorted(Comparator.comparingInt((Movie movie)->movie.releaseYear).reversed())
                                    .limit(5)
                                    .collect(Collectors.toList());

        if(top5Movies.isEmpty()){
            System.out.println("No movies found.");
            return;
        }
        System.out.println("Top movies (year-wise): ");
        for(Movie movie: top5Movies){
            System.out.println(movie);
        }

    }

    private static boolean validateYear(int year){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse("01-01-"+year, formatter);
            return true;
        } 
        catch (DateTimeParseException e) {
            return false;
        }
    }

}