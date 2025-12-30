public class Level2 {
    public static void main(String[] args) {
        System.out.println("=== Student Report ===");
        Student student1 = new Student("Alice Johnson", 101, 85.5);
        student1.displayDetails();
        
        System.out.println("\n=== ATM Simulation ===");
        BankAccount account1 = new BankAccount("John Smith", "1234567890", 1000.0);
        account1.displayBalance();
        account1.deposit(500.0);
        account1.withdraw(200.0);
        account1.displayBalance();
        
        System.out.println("\n=== Palindrome Checker ===");
        PalindromeChecker checker1 = new PalindromeChecker("A man, a plan, a canal: Panama");
        checker1.displayResult();
        PalindromeChecker checker2 = new PalindromeChecker("Hello World");
        checker2.displayResult();
        
        System.out.println("\n=== Movie Ticket Booking ===");
        MovieTicket ticket1 = new MovieTicket("Avengers: Endgame", 15.99);
        ticket1.displayTicketDetails();
        ticket1.bookTicket("A12");
        ticket1.displayTicketDetails();
        
        System.out.println("\n=== Shopping Cart ===");
        CartItem item1 = new CartItem("Laptop", 999.99);
        item1.addItem(2);
        item1.removeItem(1);
        item1.displayDetails();
    }
} 