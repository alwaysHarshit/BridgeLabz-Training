import java.util.ArrayList;
import java.util.List;

abstract class FoodItem {
    protected String itemName;
    protected double price;
    protected int quantity;

    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    abstract double calculateTotalPrice();

    String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

class VegItem extends FoodItem {
    VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    double calculateTotalPrice() {
        return price * quantity; // No additional charges for veg items
    }
}

class NonVegItem extends FoodItem {
    NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    double calculateTotalPrice() {
        double additionalCharge = 1.5; // Additional charge for non-veg items
        return (price + additionalCharge) * quantity;
    }
}

interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

class Order implements Discountable {
    private List<FoodItem> foodItems = new ArrayList<>();
    private double discountPercentage;

    void addFoodItem(FoodItem foodItem) {
        foodItems.add(foodItem);
    }

    @Override
    public void applyDiscount(double percentage) {
        this.discountPercentage = percentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount applied: " + discountPercentage + "%";
    }

    double calculateTotalOrderPrice() {
        double total = 0;
        for (FoodItem item : foodItems) {
            total += item.calculateTotalPrice();
        }
        return total - (total * discountPercentage / 100);
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        Order order = new Order();
        order.addFoodItem(new VegItem("Veg Pizza", 8.99, 2));
        order.addFoodItem(new NonVegItem("Chicken Burger", 5.99, 1));

        order.applyDiscount(10); // Applying a 10% discount

        System.out.println(order.getDiscountDetails());
        System.out.println("Total Order Price: $" + order.calculateTotalOrderPrice());
    }
}