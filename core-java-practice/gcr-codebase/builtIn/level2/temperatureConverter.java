import java.util.Scanner;

public class temperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Temperature Converter");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Choose option (1 or 2): ");
        int choice = sc.nextInt();
        
        System.out.print("Enter temperature: ");
        double temperature = sc.nextDouble();
        
        double result = 0;
        if (choice == 1) {
            result = fahrenheitToCelsius(temperature);
            System.out.println(temperature + "°F = " + result + "°C");
        } else if (choice == 2) {
            result = celsiusToFahrenheit(temperature);
            System.out.println(temperature + "°C = " + result + "°F");
        } else {
            System.out.println("Invalid choice!");
        }
    }
    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
    
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }
} 