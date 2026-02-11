package addressbooksystem.service;

import java.util.HashMap;
import java.util.Map;

public class AddressBookManager {
    // Dictionary: Key = AddressBook Name, Value = AddressBookService Instance
    private Map<String, AddressBookService> addressBookMap = new HashMap<>();

    public void addAddressBook(String name) {
        if (addressBookMap.containsKey(name)) {
            System.out.println("An Address Book with this name already exists.");
        } else {
            addressBookMap.put(name, new AddressBookService());
            System.out.println("Address Book '" + name + "' created successfully.");
        }
    }

    public AddressBookService getAddressBook(String name) {
        return addressBookMap.get(name);
    }

    public void listAddressBooks() {
        if (addressBookMap.isEmpty()) {
            System.out.println("No Address Books available.");
        } else {
            System.out.println("Available Address Books: " + addressBookMap.keySet());
        }
    }
}