package FutureLogistics;

public class TimberTransport extends GoodsTransport {
    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, int transportRating,
                           float timberLength, float timberRadius, String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

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

    @Override
    public String vehicleSelection() {
        // Calculate area: 2 * 3.147 * timberRadius * timberLength
        float area = 2 * 3.147f * timberRadius * timberLength;

        if (area < 250) {
            return "Truck";
        } else if (area >= 250 && area <= 400) {
            return "Lorry";
        } else {
            return "MonsterLorry";
        }
    }

    @Override
    public float calculateTotalCharge() {
        // Calculate volume: 3.147 * timberRadius * timberRadius * timberLength
        float volume = 3.147f * timberRadius * timberRadius * timberLength;

        // Calculate price based on timber type
        float timberTypeFactor = 0;
        if (timberType.equalsIgnoreCase("Premium")) {
            timberTypeFactor = 0.25f;
        } else if (timberType.equalsIgnoreCase("NonPremium")) {
            timberTypeFactor = 0.15f;
        }

        float price = volume * timberPrice * timberTypeFactor;

        // Calculate tax (30% of price)
        float tax = price * 0.3f;

        // Get vehicle price
        String vehicle = vehicleSelection();
        float vehiclePrice = 0;
        if (vehicle.equalsIgnoreCase("Truck")) {
            vehiclePrice = 1000;
        } else if (vehicle.equalsIgnoreCase("Lorry")) {
            vehiclePrice = 1700;
        } else if (vehicle.equalsIgnoreCase("MonsterLorry")) {
            vehiclePrice = 3000;
        }

        // Calculate discount based on transport rating
        float discountPercentage = 0;
        if (transportRating == 5) {
            discountPercentage = 20;
        } else if (transportRating == 3 || transportRating == 4) {
            discountPercentage = 10;
        }

        float discount = price * discountPercentage / 100;

        // Calculate total charge
        float totalCharge = price + vehiclePrice + tax - discount;

        return totalCharge;
    }
}
