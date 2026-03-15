package m1.problems;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


class Product{
    private String name;
    private double price;
    private  int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


}
class Electronics extends Product {
    private int warrenty;

    public Electronics(String name, double price, int quantity, int warrenty) {
        super(name, price, quantity);
        this.warrenty = warrenty;
    }

    @Override
    public String toString() {
        return String.format("%s - Price: %.2f, Quantity: %d, Warrenty: %d", super.getName(),super.getPrice(),super.getQuantity(),this.warrenty);
    }
}
class Cloths extends Product{
    private String size;

    public Cloths(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("%s - Price: %.2f, Quantity: %d, Size: %s", super.getName(),super.getPrice(),super.getQuantity(),this.size);
    }
}


public class SupermarketStoreInventorySystem {

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bf.readLine().trim());
        List<Product>ls=new ArrayList<>();

        while (t-- >0){
            String s = bf.readLine().replaceAll(" ","");
            String[]part=s.split(",");
            if(part[0].equalsIgnoreCase("Electronics")){
                Product product=new Electronics(part[1],Double.parseDouble(part[2]),Integer.parseInt(part[3]),Integer.parseInt(part[4]));
                ls.add(product);
                System.out.printf("Product added to inventory: %s%n",part[1]);
            }
            else if(part[0].equalsIgnoreCase("Clothing")){
                Product product=new Cloths(part[1],Double.parseDouble(part[2]),Integer.parseInt(part[3]),part[4]);
                ls.add(product);
                System.out.printf("Product added to inventory: %s%n",part[1]);
            }
        }
        System.out.printf("Inventory:%n");
        ls.stream().forEach(product -> {
            System.out.println(product);
        });

        double sum = ls.stream().
                mapToDouble(p->p.getPrice()* p.getQuantity()).
                sum();
        System.out.printf("%nTotal value of the inventory: %.2f",sum);

    }
}

