public class MobilePhone {
    private String brand;
    private String model;
    private double price;
    
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    
    public void displayDetails() {
        System.out.println("Mobile Phone Brand: " + brand);
        System.out.println("Mobile Phone Model: " + model);
        System.out.println("Mobile Phone Price: $" + price);
    }
} 