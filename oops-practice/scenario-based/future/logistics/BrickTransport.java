package scenariobased.future.logistics;

import java.util.Map;

public class BrickTransport extends GoodsTransport {
    float brickSize;
    int brickQuantity;
    float brickPrice;
    Map<String,Integer>map;

    final double TAX=2.3;

    public float getBrickSize() {
        return brickSize;
    }

    public void setBrickSize(float brickSize) {
        this.brickSize = brickSize;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }

    public void setBrickQuantity(int brickQuantity) {
        this.brickQuantity = brickQuantity;
    }

    public float getBrickPrice() {
        return brickPrice;
    }

    public void setBrickPrice(float brickPrice) {
        this.brickPrice = brickPrice;
    }

    public BrickTransport(String transportId, String transportDate, int transportRating, float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating); // calling the constructor of parenet class
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;

        map = Map.of("Truck", 1000,
                "Lorry", 1700,
                "MonsterLorry", 3000
        );
    }


    @Override
    public String vehicleSelection() {
        if(getBrickQuantity()<300) return "Truck";

        else if(getBrickQuantity() >=300 && getBrickQuantity()<=500) return "Lorry";

        else return "MonsterLorry";

    }

    @Override
    public float calculateTotalCharge() {
        float price = (getBrickPrice() * getBrickQuantity());
        double tax = price * TAX;
        double discount = price * calculateDis(transportRating);
        Integer vehicle= map.get(vehicleSelection());

        return (float) (((price) + vehicle + tax) - discount);
    }

    private double calculateDis(int transportRating) {
        if(transportRating==5){
            return 0.20d;
        } else if (transportRating ==3 || transportRating==4) return 0.10d;
        else  return 0.0d;
    }
}
