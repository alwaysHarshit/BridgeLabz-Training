import java.util.Arrays;
import java.util.List;

public class IoTSensorReadings {
    
    public static void printReadingsAboveThreshold(List<Double> readings, double threshold){
        readings.stream().filter(reading -> reading>=threshold)
                        .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Double> readings = Arrays.asList(20.5,18.5,50.2,45.1,23.2,35.8,67.5,14.3,26.5,35.5,37.6);

        printReadingsAboveThreshold(readings, 30.8);
    }
}
