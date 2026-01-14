package online.examination.system;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    private int examId;
    private String examName;
    private int durationMinutes;
    private List<Question> questions;
    private List<Student> enrolledStudents;
    private boolean isActive;

    public Exam(int examId, String examName, int durationMinutes) {
        this.examId = examId;
        this.examName = examName;
        this.durationMinutes = durationMinutes;
        this.questions = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.isActive = true;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public boolean removeQuestion(int questionId) {
        return questions.removeIf(q -> q.getQuestionId() == questionId);
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void deactivateExam() {
        this.isActive = false;
    }

    public void activateExam() {
        this.isActive = true;
    }

    public int getExamId() {
        return examId;
    }

    public String getExamName() {
        return examName;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getTotalMarks() {
        int total = 0;
        for (Question q : questions) {
            total += q.getMarks();
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("Exam #%d: %s | Duration: %d mins | Questions: %d | Total Marks: %d",
            examId, examName, durationMinutes, questions.size(), getTotalMarks());
    }
}
