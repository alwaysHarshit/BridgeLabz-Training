package addressbooksystem.model;

public class Contact {
    private String firstName, lastName, address, city, state, zip, phoneNumber, email;

    public Contact(String firstName, String lastName, String address, String city, 
                   String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Standard Getters/Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() {return lastName;}
    
    public String getCity() {return city;}
    public String getState() {return state;}
    
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setAddress(String Address) {
    	this.address = address;
    }
    public void setCity(String city) {this.city = city;}
    public void setState(String state) {this.state = state;}
    public void setZip(String zip) { this.zip = zip; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
    	

    @Override
    public String toString() {
        return "Contact [Name=" + firstName + " " + lastName + ", Address=" + address + 
               ", City=" + city + ", State=" + state + ", Zip=" + zip + 
               ", Phone=" + phoneNumber + ", Email=" + email + "]";
    }
}
