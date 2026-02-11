package addressbooksystem.service;

import addressbooksystem.model.Contact;
import java.util.ArrayList;
import java.util.List;

public class AddressBookService {
    private List<Contact> contactList = new ArrayList<>();

    public void addContact(Contact newContact) {
        // UC 7: Check for duplicate using Java Stream
        boolean isDuplicate = contactList.stream()
                .anyMatch(contact -> contact.getFirstName().equalsIgnoreCase(newContact.getFirstName()) 
                                  && contact.getLastName().equalsIgnoreCase(newContact.getLastName()));

        if (isDuplicate) {
            System.out.println("Error: A contact with the name '" + newContact.getFirstName() + " " + 
                               newContact.getLastName() + "' already exists in this Address Book.");
        } else {
            contactList.add(newContact);
            System.out.println("Contact added successfully!");
        }
    }

    public List<Contact> getAllContacts() {
        return contactList;
    }
    //UC3
    public Contact findContactByName(String firstName) {   //Method to find the name of the contact using Name;
    	for(Contact contact : contactList)
    	{
    		if(contact.getFirstName().equalsIgnoreCase(firstName)) {     //this will check the name is in the contact or not
    			return contact;
    		}
    	}
    	return null;  //return null if not found;
    }
    
    //UC4
    public boolean deleteContact(String firstName) {      //Method to delete the COntact using first Name
    	return contactList.removeIf(contact -> contact.getFirstName().equalsIgnoreCase(firstName));
    }
    
}
