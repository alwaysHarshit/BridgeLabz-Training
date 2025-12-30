public class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;
    
    public MovieTicket(String movieName, double price) {
        this.movieName = movieName;
        this.price = price;
        this.seatNumber = "Not assigned";
    }
    
    public void bookTicket(String seatNumber) {
        this.seatNumber = seatNumber;
        System.out.println("Ticket booked successfully!");
        System.out.println("Seat assigned: " + seatNumber);
    }
    
    public void displayTicketDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: $" + price);
    }
} 