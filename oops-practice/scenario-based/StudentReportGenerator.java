package scenariobased;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentReportGenerator {
    private List<Student> students;

    public StudentReportGenerator() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("✓ Student record added successfully!");
    }

    public void displayAllReports() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n🎓 Displaying all student reports...");
        for (Student student : students) {
            student.displayReportCard();
        }
    }

    public void searchStudent(String name) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                student.displayReportCard();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found in records.");
        }
    }

    public static void main(String[] args) {
        StudentReportGenerator generator = new StudentReportGenerator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Report Generator ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Reports");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Roll number: ");
                    String rollNumber = scanner.nextLine();

                    System.out.print("How many subjects? ");
                    int subjectCount = scanner.nextInt();
                    scanner.nextLine();

                    String[] subjects = new String[subjectCount];
                    int[] marks = new int[subjectCount];

                    for (int i = 0; i < subjectCount; i++) {
                        System.out.printf("Subject %d name: ", i + 1);
                        subjects[i] = scanner.nextLine();

                        System.out.printf("Marks for %s (0-100): ", subjects[i]);
                        marks[i] = scanner.nextInt();
                        scanner.nextLine();
                    }

                    try {
                        Student student = new Student(name, rollNumber, subjects, marks);
                        generator.addStudent(student);
                    } catch (InvalidMarkException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    generator.displayAllReports();
                    break;

                case 3:
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    generator.searchStudent(searchName);
                    break;

                case 4:
                    System.out.println("Exiting report generator...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
