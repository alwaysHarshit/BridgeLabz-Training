package generics;
import java.util.*;

abstract class ProductCategory {
    private String categoryName;
    public ProductCategory(String name){ this.categoryName = name; }
    public String getCategoryName(){ return categoryName; }
}

class BookCategory extends ProductCategory { public BookCategory(){ super("Book"); } }
class ClothingCategory extends ProductCategory { public ClothingCategory(){ super("Clothing"); } }
class GadgetCategory extends ProductCategory { public GadgetCategory(){ super("Gadget"); } }

class Product<T extends ProductCategory> {
    private String id;
    private double price;
    private T category;
    public Product(String id, double price, T category) {
        this.id = id; this.price = price; this.category = category;
    }
    public double getPrice() { return price; }
    public void setPrice(double p) { price = p; }
    @Override public String toString() {
        return "Product[id=" + id + ", price=" + price + ", category=" + category.getCategoryName() + "]";
    }
}

public class DynamicOnlineMarketPlace {
    public static <P extends Product<? extends ProductCategory>> void applyDiscount(P product, double percent) {
        double newPrice = product.getPrice() * (1 - percent/100);
        product.setPrice(newPrice);
    }

    public static void main(String[] args) {
        List<Product<? extends ProductCategory>> catalog = new ArrayList<>();
        catalog.add(new Product<>("B1", 100.0, new BookCategory()));
        catalog.add(new Product<>("C1", 50.0, new ClothingCategory()));
        catalog.add(new Product<>("G1", 250.0, new GadgetCategory()));

        System.out.println("Before discount:");
        catalog.forEach(System.out::println);

        catalog.forEach(p -> applyDiscount(p, 10));

        System.out.println("\nAfter 10% discount:");
        catalog.forEach(System.out::println);
    }
}
