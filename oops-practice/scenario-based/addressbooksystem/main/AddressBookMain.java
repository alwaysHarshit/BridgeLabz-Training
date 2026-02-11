package addressbooksystem.main;

import addressbooksystem.model.Contact;
import addressbooksystem.service.AddressBookService;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;


public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        
        Scanner sc = new Scanner(System.in);
        // UC 6: Dictionary to maintain multiple Address Books (Name -> Service)
        Map<String, AddressBookService> addressBookMap = new HashMap<>();
        
        boolean exitSystem = false;
        while (!exitSystem) {
            System.out.println("\n--- System Menu (Multiple Books) ---");
            System.out.println("1. Create New Address Book");
            System.out.println("2. Open Existing Address Book");
            System.out.println("3. List All Address Books");
            System.out.println("4. Search Person in City or State");// UC 7
            System.out.println("5. View Persons by City or State"); // New UC 9
            System.out.println("6. Get Count of Persons by City or State"); // New UC 10
            System.out.println("7. Exit");
            System.out.print("Choice: ");
            
            int mainChoice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (mainChoice) {
            case 1:
                System.out.print("Enter a unique name for the new Address Book: ");
                String name = sc.nextLine();
                if (addressBookMap.containsKey(name)) {
                    System.out.println("Error: An Address Book with this name already exists.");
                } else {
                    addressBookMap.put(name, new AddressBookService());
                    System.out.println("Address Book '" + name + "' created successfully.");
                }
                break;

            case 2:
                System.out.print("Enter name of Address Book to open: ");
                String bookToOpen = sc.nextLine();
                AddressBookService selectedService = addressBookMap.get(bookToOpen);
                
                if (selectedService != null) {
                    manageContacts(selectedService, sc);
                } else {
                    System.out.println("Address Book not found.");
                }
                break;

            case 3:
                if (addressBookMap.isEmpty()) {
                    System.out.println("No Address Books available.");
                } else {
                    System.out.println("Available Address Books: " + addressBookMap.keySet());
                }
                break;

            case 4:
                // UC 8: Global Search across all Address Books
                System.out.println("1. Search by City | 2. Search by State");
                int searchType = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.print("Enter name of location: ");
                String location = sc.nextLine();

                System.out.println("\n--- Search Results ---");
                addressBookMap.values().stream()
                    .flatMap(service -> service.getAllContacts().stream())
                    .filter(c -> c.getCity().equalsIgnoreCase(location) || 
                                 c.getState().equalsIgnoreCase(location))
                    .forEach(System.out::println);
                break;
            case 5:
                System.out.println("1. View by City | 2. View by State");
                int viewChoice = sc.nextInt();
                sc.nextLine(); // consume newline

                if (viewChoice == 1) {
                    // Create Dictionary of City -> List of Contacts
                    Map<String, List<Contact>> cityMap = addressBookMap.values().stream()
                        .flatMap(service -> service.getAllContacts().stream())
                        .collect(Collectors.groupingBy(Contact::getCity));

                    cityMap.forEach((city, contacts) -> {
                        System.out.println("\nCity: " + city);
                        contacts.forEach(System.out::println);
                    });
                } else {
                    // Create Dictionary of State -> List of Contacts
                    Map<String, List<Contact>> stateMap = addressBookMap.values().stream()
                        .flatMap(service -> service.getAllContacts().stream())
                        .collect(Collectors.groupingBy(Contact::getState));

                    stateMap.forEach((state, contacts) -> {
                        System.out.println("\nState: " + state);
                        contacts.forEach(System.out::println);
                    });
                }
                break;
                
            case 6:
                System.out.println("1. Count by City | 2. Count by State");
                int countChoice = sc.nextInt();
                sc.nextLine(); // consume newline

                if (countChoice == 1) {
                    // Map: Key = City Name, Value = Count of People
                    Map<String, Long> cityCount = addressBookMap.values().stream()
                        .flatMap(service -> service.getAllContacts().stream())
                        .collect(Collectors.groupingBy(Contact::getCity, Collectors.counting()));

                    System.out.println("\n--- Count by City ---");
                    cityCount.forEach((city, count) -> System.out.println(city + ": " + count));
                } else {
                    // Map: Key = State Name, Value = Count of People
                    Map<String, Long> stateCount = addressBookMap.values().stream()
                        .flatMap(service -> service.getAllContacts().stream())
                        .collect(Collectors.groupingBy(Contact::getState, Collectors.counting()));

                    System.out.println("\n--- Count by State ---");
                    stateCount.forEach((state, count) -> System.out.println(state + ": " + count));
                }
                break;

            case 7:
                // Moved Exit logic here
                exitSystem = true;
                System.out.println("Exiting System. Goodbye!");
                break;
                

            default:
                System.out.println("Invalid choice. Try again.");
        }

        }
        
        sc.close();
    }

    
     // Sub-menu to handle contacts within a specific selected Address Book
     
    private static void manageContacts(AddressBookService service, Scanner sc) {
        boolean backToMain = false;
        while (!backToMain) {
            System.out.println("\n--- Contact Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Edit Contact by Name");
            System.out.println("4. Delete Contact by Name");
            System.out.println("5. Back to System Menu");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    boolean addMore = true;
                    while (addMore) {
                        Contact newContact = promptForContact(sc);
                        service.addContact(newContact);
                        System.out.println("Contact added successfully!");
                        System.out.print("Do you want to add another contact? (y/n): ");
                        if (sc.nextLine().equalsIgnoreCase("n")) addMore = false;
                    }
                    break;

                case 2:
                    if (service.getAllContacts().isEmpty()) {
                        System.out.println("This Address Book is empty.");
                    } else {
                        service.getAllContacts().forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("Enter the First Name of the contact to edit: ");
                    String nameToEdit = sc.nextLine();
                    Contact foundContact = service.findContactByName(nameToEdit);
                    if (foundContact != null) {
                        editContactDetails(foundContact, sc);
                        System.out.println("Contact updated successfully!");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the Name of the contact to delete: ");
                    String nameToDelete = sc.nextLine();
                    if (service.deleteContact(nameToDelete)) {
                        System.out.println("Contact deleted successfully!");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 5:
                    backToMain = true;
                    break;
            }
        }
    }

    private static Contact promptForContact(Scanner sc) {
        System.out.print("First Name: "); String fn = sc.nextLine();
        System.out.print("Last Name: "); String ln = sc.nextLine();
        System.out.print("Address: "); String addr = sc.nextLine();
        System.out.print("City: "); String city = sc.nextLine();
        System.out.print("State: "); String state = sc.nextLine();
        System.out.print("Zip: "); String zip = sc.nextLine();
        System.out.print("Phone: "); String ph = sc.nextLine();
        System.out.print("Email: "); String em = sc.nextLine();
        return new Contact(fn, ln, addr, city, state, zip, ph, em);
    }

    private static void editContactDetails(Contact contact, Scanner sc) {
        System.out.print("New Last Name: "); contact.setLastName(sc.nextLine());
        System.out.print("New Address: "); contact.setAddress(sc.nextLine());
        System.out.print("New City: "); contact.setCity(sc.nextLine());
        System.out.print("New State: "); contact.setState(sc.nextLine());
        System.out.print("New Zip: "); contact.setZip(sc.nextLine());
        System.out.print("New Phone: "); contact.setPhoneNumber(sc.nextLine());
        System.out.print("New Email: "); contact.setEmail(sc.nextLine());
    }
}