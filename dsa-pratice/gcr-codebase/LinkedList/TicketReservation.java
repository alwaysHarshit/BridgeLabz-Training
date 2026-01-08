package com.Linkedlist;
import java.util.*;

public class TicketReservation {

    static class Ticket {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Ticket next;

        public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    // Ticket Reservation Logic
    private Ticket head = null;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
        System.out.println("✅ Ticket added successfully.");
    }

    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("⚠️ No tickets found.");
            return;
        }

        Ticket curr = head;
        Ticket prev = null;

        if (head.next == head && head.ticketId == ticketId) {
            head = null;
            System.out.println("✅ Ticket removed.");
            return;
        }

        do {
            if (curr.ticketId == ticketId) {
                if (curr == head) {
                    Ticket temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("✅ Ticket removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("❌ Ticket ID not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("⚠️ No tickets to display.");
            return;
        }

        System.out.println("\n--- 🎫 All Booked Tickets ---");
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId);
            System.out.println("Customer: " + temp.customerName);
            System.out.println("Movie: " + temp.movieName);
            System.out.println("Seat: " + temp.seatNumber);
            System.out.println("Time: " + temp.bookingTime);
            System.out.println("---------------------------");
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String key) {
        if (head == null) {
            System.out.println("⚠️ No tickets to search.");
            return;
        }

        boolean found = false;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(key) || temp.movieName.equalsIgnoreCase(key)) {
                System.out.println("Ticket ID: " + temp.ticketId);
                System.out.println("Customer: " + temp.customerName);
                System.out.println("Movie: " + temp.movieName);
                System.out.println("Seat: " + temp.seatNumber);
                System.out.println("Time: " + temp.bookingTime);
                System.out.println("---------------------------");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("❌ No matching tickets found.");
    }

    public void countTickets() {
        if (head == null) {
            System.out.println("Total tickets booked: 0");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("✅ Total tickets booked: " + count);
    }

    // ----------------------- MAIN METHOD -----------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservation system = new TicketReservation();

        while (true) {
            System.out.println("\n🎟️ --- Ticket Reservation System ---");
            System.out.println("1. Add Ticket");
            System.out.println("2. Remove Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Customer or Movie");
            System.out.println("5. Count Total Tickets");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            int ticketId;
            String name, movie, seat, time;

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    ticketId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    time = sc.nextLine();
                    system.addTicket(ticketId, name, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    ticketId = sc.nextInt();
                    system.removeTicket(ticketId);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer or Movie name: ");
                    String key = sc.nextLine();
                    system.searchTicket(key);
                    break;

                case 5:
                    system.countTickets();
                    break;

                case 6:
                    System.out.println("👋 Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }
}
