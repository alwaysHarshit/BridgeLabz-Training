package hospital.patient.management.system;

abstract class Person {

    //fields
    private String name;
    private  int age;
    private String gender;
    private String contactNumber;
    private String address;
    //constructor
    public Person(String name, int age, String gender, String contactNumber, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    //methods
    public abstract String getRole();

    public String getName() {
        return name;
    }

    public void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Contact: " + contactNumber);
        System.out.println("Address: " + address);
        System.out.println("------------------------");
    }







}
