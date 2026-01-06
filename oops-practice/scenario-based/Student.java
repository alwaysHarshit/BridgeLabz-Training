package scenariobased;

public class Student {
    private String name;
    private String rollNumber;
    private String[] subjects;
    private int[] marks;

    public Student(String name, String rollNumber, String[] subjects, int[] marks) throws InvalidMarkException {
        validateMarks(marks);
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjects = subjects;
        this.marks = marks;
    }

    private void validateMarks(int[] marks) throws InvalidMarkException {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarkException(
                    String.format("Invalid mark at position %d: %d (must be between 0-100)", i, marks[i])
                );
            }
        }
    }

    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    public String assignGrade() {
        double avg = calculateAverage();

        if (avg >= 90) return "A+";
        else if (avg >= 80) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }

    public void displayReportCard() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("                    📜 REPORT CARD");
        System.out.println("═".repeat(60));
        System.out.printf("Student Name    : %s%n", name);
        System.out.printf("Roll Number     : %s%n", rollNumber);
        System.out.println("─".repeat(60));
        System.out.printf("%-25s | %-10s%n", "Subject", "Marks");
        System.out.println("─".repeat(60));

        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-25s | %-10d%n", subjects[i], marks[i]);
        }

        System.out.println("─".repeat(60));
        System.out.printf("Average         : %.2f%%%n", calculateAverage());
        System.out.printf("Overall Grade   : %s%n", assignGrade());
        System.out.println("═".repeat(60) + "\n");
    }

    public String getName() {
        return name;
    }
}
