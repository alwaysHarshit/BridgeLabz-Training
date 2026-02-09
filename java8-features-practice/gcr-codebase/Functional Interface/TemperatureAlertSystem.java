
    import java.util.function.Predicate;

    public class TemperatureAlertSystem {

        public static void main(String[] args) {

            double threshold = 37.5;

            // Predicate to check if temperature is above threshold
            Predicate<Double> isTooHot = temp -> temp > threshold;

            double[] readings = {36.5, 37.0, 37.8, 38.2, 36.9};

            for (double temp : readings) {
                if (isTooHot.test(temp)) {
                    System.out.println("⚠ ALERT! High temperature detected: " + temp);
                } else {
                    System.out.println("Temperature normal: " + temp);
                }
            }
        }
    }


