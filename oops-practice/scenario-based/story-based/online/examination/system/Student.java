package online.examination.system;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private Map<Integer, String> submittedAnswers;
    private int totalScore;
    private boolean hasSubmitted;

    public Student(int studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.submittedAnswers = new HashMap<>();
        this.totalScore = 0;
        this.hasSubmitted = false;
    }

    public void submitAnswer(int questionId, String answer) {
        submittedAnswers.put(questionId, answer);
    }

    public String getAnswer(int questionId) {
        return submittedAnswers.getOrDefault(questionId, "");
    }

    public void markAsSubmitted() {
        this.hasSubmitted = true;
    }

    public boolean hasSubmitted() {
        return hasSubmitted;
    }

    public void setTotalScore(int score) {
        this.totalScore = score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Map<Integer, String> getSubmittedAnswers() {
        return submittedAnswers;
    }

    @Override
    public String toString() {
        return String.format("Student #%d: %s (%s)", studentId, name, email);
    }
}
