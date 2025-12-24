public class RandomNumberAnalyzer {
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = 1000 + (int)(Math.random() * 9000);
        }
        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        
        for (int number : numbers) {
            sum += number;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        double average = sum / numbers.length;
        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);
        
        System.out.println("Generated 4-digit random numbers:");
        for (int number : randomNumbers) {
            System.out.println(number);
        }
        
        double[] analysis = findAverageMinMax(randomNumbers);
        
        System.out.println("\nAnalysis Results:");
        System.out.printf("Average: %.2f%n", analysis[0]);
        System.out.println("Minimum: " + (int)analysis[1]);
        System.out.println("Maximum: " + (int)analysis[2]);
    }
} 