import java.util.Scanner;
import java.util.Random;

public class rockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of games:");
        int games = sc.nextInt();
        
        String[][] results = playGames(games, sc);
        displayResults(results);
    }
    
    public static String generateComputerChoice() {
        Random random = new Random();
        int choice = random.nextInt(3);
        
        switch (choice) {
            case 0: return "Rock";
            case 1: return "Paper";
            case 2: return "Scissors";
            default: return "Rock";
        }
    }
    
    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Tie";
        }
        
        if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
            (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
            (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }
    
    public static String[][] playGames(int games, Scanner sc) {
        String[][] results = new String[games + 1][4];
        
        int userWins = 0;
        int computerWins = 0;
        int ties = 0;
        
        for (int i = 0; i < games; i++) {
            System.out.println("\nGame " + (i + 1) + ":");
            System.out.println("Enter your choice (Rock/Paper/Scissors):");
            String userChoice = sc.next();
            String computerChoice = generateComputerChoice();
            String winner = determineWinner(userChoice, computerChoice);
            
            results[i][0] = String.valueOf(i + 1);
            results[i][1] = userChoice;
            results[i][2] = computerChoice;
            results[i][3] = winner;
            
            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                ties++;
            }
        }
        
        double userPercentage = (double) userWins / games * 100;
        double computerPercentage = (double) computerWins / games * 100;
        
        results[games][0] = "Total";
        results[games][1] = "User: " + userWins + " (" + String.format("%.1f", userPercentage) + "%)";
        results[games][2] = "Computer: " + computerWins + " (" + String.format("%.1f", computerPercentage) + "%)";
        results[games][3] = "Ties: " + ties;
        
        return results;
    }
    
    public static void displayResults(String[][] results) {
        System.out.println("\nGame Results:");
        System.out.println("Game\tUser\tComputer\tWinner");
        System.out.println("----------------------------------------");
        
        for (int i = 0; i < results.length - 1; i++) {
            System.out.println(results[i][0] + "\t" + results[i][1] + "\t" + results[i][2] + "\t" + results[i][3]);
        }
        
        System.out.println("\nFinal Statistics:");
        System.out.println(results[results.length - 1][1]);
        System.out.println(results[results.length - 1][2]);
        System.out.println(results[results.length - 1][3]);
    }
} 