package csv.intermediate.problems;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilterStudentsByMarks {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("io-programming-practice/gcr-codebase/csv/basic/problems/Students.csv");

        Files.lines(path)
                .skip(1) // skip header
                .map(line -> line.split(","))
                .filter(parts -> Integer.parseInt(parts[2].trim()) > 80) // assuming: id,name,marks
                .forEach(parts ->
                        System.out.println("ID: " + parts[0] + ", Name: " + parts[1] + ", Marks: " + parts[2])
                );
    }
}
