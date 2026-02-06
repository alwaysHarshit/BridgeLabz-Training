package scenariobased.future.logistics;

import java.util.Map;

public class TimberTransport extends GoodsTransport {
    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;
    Map<String,Integer> map;

    public float getTimberLength() {
        return timberLength;
    }

    public void setTimberLength(float timberLength) {
        this.timberLength = timberLength;
    }

    public float getTimberRadius() {
        return timberRadius;
    }

    public void setTimberRadius(float timberRadius) {
        this.timberRadius = timberRadius;
    }

    public String getTimberType() {
        return timberType;
    }

    public void setTimberType(String timberType) {
        this.timberType = timberType;
    }

    public float getTimberPrice() {
        return timberPrice;
    }

    public void setTimberPrice(float timberPrice) {
        this.timberPrice = timberPrice;
    }

    public TimberTransport(String transportId, String transportDate, int transportRating, float timberLength, float timberRadius, String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;

        map = Map.of("Truck", 1000,
                "Lorry", 1700,
                "MonsterLorry", 3000
        );
    }

    @Override
    public String vehicleSelection() {
        float area = (float) (2 * 3.147 * getTimberRadius() * getTimberLength());

        if(area<250) return "Truck";
        else if (area >= 250 && area <= 400) return "Lorry";
        else return "MonsterLorry";
    }

    @Override
    public float calculateTotalCharge() {
        double Volume = 3.147 * getTimberRadius() * getTimberRadius() * getTimberLength();
        double Price = Volume * getTimberPrice() * (getTimberType() == "Premium" ? 0.25 : 0.15);
        double Tax = Price * 0.3;
        double discount = Price * calculateDis(transportRating);
        Integer vehicle= map.get(vehicleSelection());

        return (float) (((Price) + vehicle + Tax) - discount);
    }
    private double calculateDis(int transportRating) {
        if(transportRating==5){
            return 0.20d;
        } else if (transportRating ==3 || transportRating==4) return 0.10d;
        else  return 0.0d;
    }
}
