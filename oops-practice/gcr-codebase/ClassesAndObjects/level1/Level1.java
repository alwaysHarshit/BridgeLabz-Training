public class Level1 {
    public static void main(String[] args) {
        System.out.println("=== Employee Details ===");
        Employee emp1 = new Employee("John Doe", 101, 50000.0);
        emp1.displayDetails();
        
        System.out.println("\n=== Circle Calculations ===");
        Circle circle1 = new Circle(5.0);
        circle1.displayDetails();
        
        System.out.println("\n=== Inventory Item Details ===");
        Item item1 = new Item("ITM001", "Laptop", 999.99);
        item1.displayDetails();
        System.out.println("Total cost for 3 laptops: $" + item1.calculateTotalCost(3));
        
        System.out.println("\n=== Mobile Phone Details ===");
        MobilePhone phone1 = new MobilePhone("Apple", "iPhone 15", 999.0);
        phone1.displayDetails();
    }
} 