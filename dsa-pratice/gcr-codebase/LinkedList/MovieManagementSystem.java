package com.Linkedlist;
import java.util.Scanner;

class Movie {
    String title, director;
    int year;
    float rating;
    Movie prev, next;

    Movie(String title, String director, int year, float rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

class MovieList {
    Movie head, tail;

    void addFirst(String title, String director, int year, float rating) {
        Movie newNode = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void addLast(String title, String director, int year, float rating) {
        Movie newNode = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void addAtPosition(int pos, String title, String director, int year, float rating) {
        if (pos == 0) {
            addFirst(title, director, year, rating);
            return;
        }

        Movie curr = head;
        for (int i = 1; i < pos && curr != null; i++) {
            curr = curr.next;
        }

        if (curr != null) {
            Movie newNode = new Movie(title, director, year, rating);
            newNode.next = curr.next;
            newNode.prev = curr;
            if (curr.next != null) curr.next.prev = newNode;
            curr.next = newNode;
            if (newNode.next == null) tail = newNode;
        }
    }

    void deleteByTitle(String title) {
        Movie curr = head;
        while (curr != null) {
            if (curr.title.equalsIgnoreCase(title)) {
                if (curr.prev != null) curr.prev.next = curr.next;
                else head = curr.next;

                if (curr.next != null) curr.next.prev = curr.prev;
                else tail = curr.prev;

                System.out.println("Movie \"" + title + "\" deleted.");
                return;
            }
            curr = curr.next;
        }
        System.out.println("Movie not found.");
    }

    void searchByDirectorOrRating(String keyword) {
        Movie curr = head;
        boolean found = false;
        while (curr != null) {
            if (curr.director.equalsIgnoreCase(keyword) || String.valueOf(curr.rating).equals(keyword)) {
                System.out.println("Title: " + curr.title + ", Director: " + curr.director + ", Year: " + curr.year + ", Rating: " + curr.rating);
                found = true;
            }
            curr = curr.next;
        }
        if (!found) System.out.println("No movie found with that director or rating.");
    }

    void updateRating(String title, float newRating) {
        Movie curr = head;
        while (curr != null) {
            if (curr.title.equalsIgnoreCase(title)) {
                curr.rating = newRating;
                System.out.println("Rating updated for \"" + title + "\".");
                return;
            }
            curr = curr.next;
        }
        System.out.println("Movie not found.");
    }

    void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        Movie curr = head;
        System.out.println("\nMovies (Forward Order):");
        while (curr != null) {
            System.out.println("Title: " + curr.title + ", Director: " + curr.director + ", Year: " + curr.year + ", Rating: " + curr.rating);
            curr = curr.next;
        }
    }

    void displayBackward() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        Movie curr = tail;
        System.out.println("\nMovies (Reverse Order):");
        while (curr != null) {
            System.out.println("Title: " + curr.title + ", Director: " + curr.director + ", Year: " + curr.year + ", Rating: " + curr.rating);
            curr = curr.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieList list = new MovieList();

        while (true) {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Delete Movie by Title");
            System.out.println("5. Search by Director or Rating");
            System.out.println("6. Update Rating by Title");
            System.out.println("7. Display Movies Forward");
            System.out.println("8. Display Movies Backward");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            String title, director;
            int year, pos;
            float rating;

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    director = sc.nextLine();
                    System.out.print("Enter Year: ");
                    year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = sc.nextFloat();
                    list.addFirst(title, director, year, rating);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    director = sc.nextLine();
                    System.out.print("Enter Year: ");
                    year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = sc.nextFloat();
                    list.addLast(title, director, year, rating);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    director = sc.nextLine();
                    System.out.print("Enter Year: ");
                    year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = sc.nextFloat();
                    list.addAtPosition(pos, title, director, year, rating);
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter Title to Delete: ");
                    title = sc.nextLine();
                    list.deleteByTitle(title);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Enter Director or Rating to Search: ");
                    String keyword = sc.nextLine();
                    list.searchByDirectorOrRating(keyword);
                    break;

                case 6:
                    sc.nextLine();
                    System.out.print("Enter Title to Update: ");
                    title = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    rating = sc.nextFloat();
                    list.updateRating(title, rating);
                    break;

                case 7:
                    list.displayForward();
                    break;

                case 8:
                    list.displayBackward();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

