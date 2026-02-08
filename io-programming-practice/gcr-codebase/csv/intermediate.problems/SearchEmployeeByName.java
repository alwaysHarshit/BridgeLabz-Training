package csv.intermediate.problems;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Scanner;

public class SearchEmployeeByName {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("io-programming-practice/gcr-codebase/csv/basic/problems/Employees.csv");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String searchName = scanner.nextLine().trim();

        Optional<String[]> result = Files.lines(path)
                .skip(1) // skip header
                .map(line -> line.split(","))
                // assuming: id,name,department,salary
                .filter(parts -> parts[1].trim().equalsIgnoreCase(searchName))
                .findFirst();

        if (result.isPresent()) {
            String[] emp = result.get();
            System.out.println("Department: " + emp[2]);
            System.out.println("Salary: " + emp[3]);
        } else {
            System.out.println("Employee not found.");
        }
    }
}
