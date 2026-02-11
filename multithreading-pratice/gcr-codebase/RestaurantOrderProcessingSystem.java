
import java.util.ArrayList;
import java.util.List;

public class RestaurantOrderProcessingSystem{

    public static void prepareDishes(List<Chef> chefs) {
        for(Chef chef: chefs){
            chef.start();
        }

        for(Chef chef: chefs){
            try {
                chef.join();
            } 
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Kitchen closed - All orders completed");
    }
    public static void main(String[] args) {
        List<Chef> chefs = new ArrayList<>();

        chefs.add(new Chef("Chef-1", "Pizza", 3));
        chefs.add(new Chef("Chef-2", "Pasta", 2));
        chefs.add(new Chef("Chef-3", "Salad", 1));
        chefs.add(new Chef("Chef-4", "Burger", 2.5));

        prepareDishes(chefs);
    }
}

class Chef extends Thread{

    protected String chefName;
    protected String dish;
    protected double preparationTimeInSeconds;

    

    public Chef(String chefName, String dish, double preparationTimeInSeconds ) {
        this.chefName = chefName;
        this.dish = dish;
        this.preparationTimeInSeconds = preparationTimeInSeconds;
    }

    @Override
    public void run() {
        for(int i=0; i<=100 ; i+=25){
            if(i==0){
                System.out.println(chefName + " started preparing " + dish);
            }
            else{

                System.out.println(chefName + " preparing " + dish + ": " + i + "% completed");

            }
            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) {
                System.out.println("Interruption while preparing dish "+dish);
            }
        }
    }

    
}