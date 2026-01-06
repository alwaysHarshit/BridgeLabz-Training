package scenariobased;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        if (phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits. Got: " + phoneNumber);
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %s", name, phoneNumber);
    }
}
