public class CartItem {
    private String itemName;
    private double price;
    private int quantity;
    
    public CartItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = 0;
    }
    
    public void addItem(int quantity) {
        this.quantity += quantity;
        System.out.println("Added " + quantity + " " + itemName + "(s) to cart");
    }
    
    public void removeItem(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            System.out.println("Removed " + quantity + " " + itemName + "(s) from cart");
        } else {
            System.out.println("Cannot remove more items than available");
        }
    }
    
    public double calculateTotalCost() {
        return price * quantity;
    }
    
    public void displayDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per item: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total cost: $" + calculateTotalCost());
    }
} 