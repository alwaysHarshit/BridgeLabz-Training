package csv.intermediate.problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class Top5HighestPaidEmployees {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("io-programming-practice/gcr-codebase/csv/basic/problems/Employees.csv");

        List<String[]> top5 = Files.lines(path)
                .skip(1) // skip header
                .map(line -> line.split(","))
                // assuming: id,name,department,salary
                .sorted(Comparator.comparingDouble(
                        (String[] parts) -> Double.parseDouble(parts[3].trim())
                ).reversed()) // descending by salary
                .limit(5) // top 5
                .toList();

        System.out.println("Top 5 Highest Paid Employees:");
        for (String[] emp : top5) {
            System.out.println(
                    "ID: " + emp[0] +
                            ", Name: " + emp[1] +
                            ", Dept: " + emp[2] +
                            ", Salary: " + emp[3]
            );
        }
    }
}

