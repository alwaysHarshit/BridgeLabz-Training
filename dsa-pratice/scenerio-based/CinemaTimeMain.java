public class CinemaTimeMain {
    public static void main(String[] args) {
        CinemaTime cinema = new CinemaTime();

        System.out.println("=== CINEMA TIME - MOVIE SCHEDULE MANAGER ===\n");

        try {
            // Adding movies
            System.out.println("--- Adding Movies ---");
            cinema.addMovie("The Matrix Resurrections", "14:30");
            cinema.addMovie("Spider-Man: No Way Home", "17:00");
            cinema.addMovie("Dune: Part Two", "19:45");
            cinema.addMovie("Avatar: The Way of Water", "20:15");
            cinema.addMovie("The Batman", "21:30");

            // Display all movies
            cinema.displayAllMovies();

            // Search for movies
            cinema.searchMovie("Spider");
            cinema.searchMovie("The");
            cinema.searchMovie("Avatar");

            // Generate and print report
            System.out.println(cinema.generateReport());

            // Test invalid time format - will throw exception
            System.out.println("\n--- Testing Invalid Time Format ---");
            try {
                cinema.addMovie("Invalid Movie", "25:99");
            } catch (InvalidTimeFormatException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }

            // Test another invalid format
            try {
                cinema.addMovie("Another Invalid", "12:61");
            } catch (InvalidTimeFormatException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }

            // Test malformed time
            try {
                cinema.addMovie("Bad Format", "1234");
            } catch (InvalidTimeFormatException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }

            // Final display
            cinema.displayAllMovies();

            System.out.println("\nTotal movies scheduled: " + cinema.getTotalMovies());

        } catch (InvalidTimeFormatException e) {
            System.out.println("Error adding movie: " + e.getMessage());
        }
    }
}
