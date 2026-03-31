import java.util.Scanner;
import java.util.Random;

public class deckOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of players:");
        int players = sc.nextInt();
        System.out.println("Enter number of cards per player:");
        int cardsPerPlayer = sc.nextInt();
        
        if (players * cardsPerPlayer > 52) {
            System.out.println("Not enough cards! Maximum cards possible: " + (52 / players));
            return;
        }
        
        String[] deck = initializeDeck();
        shuffleDeck(deck);
        String[][] hands = distributeCards(deck, players, cardsPerPlayer);
        
        displayHands(hands);
    }
    
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
        String[] deck = new String[52];
        int index = 0;
        
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index] = rank + " of " + suit;
                index++;
            }
        }
        
        return deck;
    }
    
    public static void shuffleDeck(String[] deck) {
        Random random = new Random();
        int n = deck.length;
        
        for (int i = 0; i < n; i++) {
            int randomIndex = i + random.nextInt(n - i);
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }
    
    public static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {
        String[][] hands = new String[players][cardsPerPlayer];
        
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                hands[i][j] = deck[i * cardsPerPlayer + j];
            }
        }
        
        return hands;
    }
    
    public static void displayHands(String[][] hands) {
        System.out.println("\nPlayer Hands:");
        System.out.println("=============");
        
        for (int i = 0; i < hands.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (int j = 0; j < hands[i].length; j++) {
                System.out.println("  " + (j + 1) + ". " + hands[i][j]);
            }
            System.out.println();
        }
    }
} 