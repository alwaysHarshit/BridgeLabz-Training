package scenariobased;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneContactOrganizer {
    private List<Contact> contacts;

    public PhoneContactOrganizer() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        for (Contact existing : contacts) {
            if (existing.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("⚠️  Contact with this number already exists!");
                return;
            }
        }

        Contact newContact = new Contact(name, phoneNumber);
        contacts.add(newContact);
        System.out.println("✓ Contact added successfully!");
    }

    public void deleteContact(String phoneNumber) {
        int initialSize = contacts.size();
        contacts.removeIf(contact -> contact.getPhoneNumber().equals(phoneNumber));

        if (contacts.size() < initialSize) {
            System.out.println("Contact removed.");
        } else {
            System.out.println("No contact found with that number.");
        }
    }

    public void searchContact(String query) {
        List<Contact> results = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(query.toLowerCase()) ||
                contact.getPhoneNumber().contains(query)) {
                results.add(contact);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            System.out.println("\nSearch Results:");
            System.out.println("─".repeat(50));
            for (Contact contact : results) {
                System.out.println(contact);
            }
        }
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Your contact list is empty.");
            return;
        }

        System.out.println("\n📱 All Contacts:");
        System.out.println("─".repeat(50));
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        PhoneContactOrganizer organizer = new PhoneContactOrganizer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Phone Contact Organizer ===");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. View All Contacts");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter 10-digit phone number: ");
                    String phone = scanner.nextLine();

                    try {
                        organizer.addContact(name, phone);
                    } catch (InvalidPhoneNumberException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter phone number to delete: ");
                    String deletePhone = scanner.nextLine();
                    organizer.deleteContact(deletePhone);
                    break;

                case 3:
                    System.out.print("Search by name or number: ");
                    String query = scanner.nextLine();
                    organizer.searchContact(query);
                    break;

                case 4:
                    organizer.displayAllContacts();
                    break;

                case 5:
                    System.out.println("Thanks for using the organizer!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
