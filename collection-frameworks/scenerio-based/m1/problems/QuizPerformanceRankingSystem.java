package m1.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class StudentRecord {

    private String studentName;
    private String department;
    private int quiz1;
    private int quiz2;
    private int quiz3;

    public StudentRecord(String studentName, String department, int quiz1, int quiz2, int quiz3) {
        this.studentName = studentName;
        this.department = department;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDepartment() {
        return department;
    }

    public int getQuiz1() {
        return quiz1;
    }

    public int getQuiz2() {
        return quiz2;
    }

    public int getQuiz3() {
        return quiz3;
    }
}

public class QuizPerformanceRankingSystem {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<StudentRecord> ls = new ArrayList<>();

        int t = Integer.parseInt(bf.readLine().trim());

        while (t-- > 0) {

            String[] parts = bf.readLine().trim().split(" ");

            if (parts[0].equalsIgnoreCase("Record")) {

                StudentRecord studentRecord = new StudentRecord(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[5])
                );

                ls.add(studentRecord);
            }

            else {

                if (ls.isEmpty()) {
                    System.out.println("No Records Available");
                    continue;
                }

                Map<String, Integer> collect = ls.stream()
                        .filter(studentRecord ->
                                studentRecord.getDepartment().equalsIgnoreCase(parts[1]))
                        .collect(Collectors.toMap(
                                StudentRecord::getStudentName,
                                s -> s.getQuiz1() + s.getQuiz2() + s.getQuiz3()
                        ));

                if (collect.isEmpty()) {
                    System.out.println("Department Not Found");
                }

                else {
                    collect.entrySet()
                            .stream()
                            .max(Map.Entry.comparingByValue())
                            .ifPresent(e ->
                                    System.out.println(e.getKey() + " " + e.getValue()));
                }
            }
        }
    }
}