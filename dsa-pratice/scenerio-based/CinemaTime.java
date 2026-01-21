import java.util.ArrayList;
import java.util.List;

public class CinemaTime {
    private List<String> movieTitles;
    private List<String> movieTimes;

    public CinemaTime() {
        this.movieTitles = new ArrayList<>();
        this.movieTimes = new ArrayList<>();
    }

    // Add a movie with title and showtime
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        validateTimeFormat(time);
        movieTitles.add(title);
        movieTimes.add(time);
        System.out.println("Movie added successfully: " + title + " at " + time);
    }

    // Validate time format (HH:MM in 24-hour format)
    private void validateTimeFormat(String time) throws InvalidTimeFormatException {
        if (time == null || !time.matches("\\d{2}:\\d{2}")) {
            throw new InvalidTimeFormatException("Invalid time format: " + time + ". Expected format: HH:MM");
        }

        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        if (hours < 0 || hours > 23) {
            throw new InvalidTimeFormatException("Invalid hours: " + hours + ". Hours must be between 00-23");
        }
        if (minutes < 0 || minutes > 59) {
            throw new InvalidTimeFormatException("Invalid minutes: " + minutes + ". Minutes must be between 00-59");
        }
    }

    // Search for movies by keyword
    public void searchMovie(String keyword) {
        try {
            System.out.println("\nSearch results for: \"" + keyword + "\"");
            System.out.println("=".repeat(50));
            
            boolean found = false;
            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                    String formattedEntry = String.format("%-30s | Time: %s", 
                                                          movieTitles.get(i), 
                                                          movieTimes.get(i));
                    System.out.println(formattedEntry);
                    found = true;
                }
            }
            
            if (!found) {
                System.out.println("No movies found matching: " + keyword);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid search index - " + e.getMessage());
        }
    }

    // Display all movies
    public void displayAllMovies() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("CINEMA SCHEDULE - ALL MOVIES");
        System.out.println("=".repeat(50));
        
        if (movieTitles.isEmpty()) {
            System.out.println("No movies scheduled.");
            return;
        }

        for (int i = 0; i < movieTitles.size(); i++) {
            String formattedEntry = String.format("%d. %-30s | Time: %s", 
                                                  (i + 1), 
                                                  movieTitles.get(i), 
                                                  movieTimes.get(i));
            System.out.println(formattedEntry);
        }
        System.out.println("=".repeat(50));
    }

    // Generate printable report by converting lists to arrays
    public String generateReport() {
        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = movieTimes.toArray(new String[0]);

        StringBuilder report = new StringBuilder();
        report.append("\n").append("=".repeat(50)).append("\n");
        report.append("CINEMA SCHEDULE REPORT\n");
        report.append("=".repeat(50)).append("\n");
        report.append("Total Movies: ").append(titlesArray.length).append("\n\n");

        for (int i = 0; i < titlesArray.length; i++) {
            String formattedEntry = String.format("%d. %-30s | Time: %s\n", 
                                                  (i + 1), 
                                                  titlesArray[i], 
                                                  timesArray[i]);
            report.append(formattedEntry);
        }
        report.append("=".repeat(50)).append("\n");

        return report.toString();
    }

    // Get total number of movies
    public int getTotalMovies() {
        return movieTitles.size();
    }
}
