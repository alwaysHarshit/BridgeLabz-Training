package online.examination.system;

public class Main {
    public static void main(String[] args) {
        ExamManagementSystem ems = new ExamManagementSystem();

        System.out.println("========================================");
        System.out.println("  Online Examination System Demo");
        System.out.println("========================================\n");

        Exam javaExam = new Exam(101, "Java Programming Fundamentals", 60);
        Exam databaseExam = new Exam(102, "Database Management Systems", 90);

        Question q1 = new Question(1, "What is the size of int in Java?", "OBJECTIVE", "4 bytes", 2);
        Question q2 = new Question(2, "Which keyword is used for inheritance?", "OBJECTIVE", "extends", 2);
        Question q3 = new Question(3, "Explain the concept of polymorphism in Java", "DESCRIPTIVE",
            "polymorphism allows objects different classes behave differently same interface method", 5);
        Question q4 = new Question(4, "What does JVM stand for?", "OBJECTIVE", "Java Virtual Machine", 3);

        javaExam.addQuestion(q1);
        javaExam.addQuestion(q2);
        javaExam.addQuestion(q3);
        javaExam.addQuestion(q4);

        Question q5 = new Question(5, "What does SQL stand for?", "OBJECTIVE", "Structured Query Language", 2);
        Question q6 = new Question(6, "Explain normalization in databases", "DESCRIPTIVE",
            "normalization process organizing data reduce redundancy improve integrity", 6);

        databaseExam.addQuestion(q5);
        databaseExam.addQuestion(q6);

        System.out.println("--- CRUD Operations: Creating Exams ---");
        ems.createExam(javaExam);
        ems.createExam(databaseExam);

        System.out.println("\n--- Reading All Exams ---");
        ems.listAllExams();

        System.out.println("\n--- Updating Exam Details ---");
        ems.updateExam(102, "Advanced Database Systems", 120);

        System.out.println("\n--- Student Enrollment ---");
        Student student1 = new Student(201, "Rahul Sharma", "rahul.sharma@university.edu");
        Student student2 = new Student(202, "Priya Mehta", "priya.mehta@university.edu");
        Student student3 = new Student(203, "Arjun Kapoor", "arjun.k@university.edu");

        javaExam.enrollStudent(student1);
        javaExam.enrollStudent(student2);
        databaseExam.enrollStudent(student3);

        System.out.printf("✓ Enrolled %s in %s\n", student1.getName(), javaExam.getExamName());
        System.out.printf("✓ Enrolled %s in %s\n", student2.getName(), javaExam.getExamName());
        System.out.printf("✓ Enrolled %s in %s\n", student3.getName(), databaseExam.getExamName());

        System.out.println("\n--- Student 1: Taking Java Exam ---");
        student1.submitAnswer(1, "4 bytes");
        student1.submitAnswer(2, "extends");
        student1.submitAnswer(3, "Polymorphism allows objects of different classes to behave differently using the same interface or method");
        student1.submitAnswer(4, "Java Virtual Machine");

        try {
            ems.submitExam(javaExam, student1, 55);
        } catch (ExamTimeExpiredException e) {
            System.out.println("⚠ " + e.getMessage());
            System.out.println("Submission rejected due to timeout.");
        }

        System.out.println("\n--- Student 2: Taking Java Exam (Time Exceeded) ---");
        student2.submitAnswer(1, "4 bytes");
        student2.submitAnswer(2, "implements");
        student2.submitAnswer(3, "It is about inheritance");
        student2.submitAnswer(4, "JVM");

        try {
            ems.submitExam(javaExam, student2, 75);
        } catch (ExamTimeExpiredException e) {
            System.out.println("⚠ " + e.getMessage());
            System.out.println("Submission not accepted. Please contact the exam coordinator.");
        }

        System.out.println("\n--- Student 3: Taking Database Exam ---");
        student3.submitAnswer(5, "Structured Query Language");
        student3.submitAnswer(6, "Normalization is a process to organize data in a database to reduce redundancy and improve data integrity");

        try {
            ems.submitExam(databaseExam, student3, 85);
        } catch (ExamTimeExpiredException e) {
            System.out.println("⚠ " + e.getMessage());
        }

        System.out.println("\n========================================");
        System.out.println("  Result Generation");
        System.out.println("========================================");

        ems.evaluateAndGenerateResult(javaExam, student1);
        ems.evaluateAndGenerateResult(databaseExam, student3);

        System.out.println("\n--- Attempting to Delete an Exam ---");
        ems.deleteExam(101);

        System.out.println("\n--- Final List of Active Exams ---");
        ems.listAllExams();

        System.out.println("\n========================================");
        System.out.println("  Demo Completed Successfully!");
        System.out.println("========================================");
    }
}
