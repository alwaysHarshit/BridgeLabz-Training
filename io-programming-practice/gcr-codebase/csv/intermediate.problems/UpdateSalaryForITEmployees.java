package csv.intermediate.problems;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class UpdateSalaryForITEmployees {
    public static void main(String[] args) throws IOException {
        Path inputPath = Path.of("io-programming-practice/gcr-codebase/csv/basic/problems/Employees.csv");
        Path outputPath = Path.of("io-programming-practice/gcr-codebase/csv/basic/problems/Employees_Updated.csv");

        List<String> lines = Files.readAllLines(inputPath);

        try (BufferedWriter bw = Files.newBufferedWriter(outputPath)) {
            // write header as-is
            bw.write(lines.get(0));
            bw.newLine();

            // process records
            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");

                String id = parts[0];
                String name = parts[1];
                String department = parts[2];
                double salary = Double.parseDouble(parts[3]);

                if (department.trim().equalsIgnoreCase("IT")) {
                    salary = salary * 1.10; // increase by 10%
                }

                String updatedLine = id + "," + name + "," + department + "," + salary;
                bw.write(updatedLine);
                bw.newLine();
            }
        }

        System.out.println("Updated file written to: " + outputPath.toAbsolutePath());
    }
}
