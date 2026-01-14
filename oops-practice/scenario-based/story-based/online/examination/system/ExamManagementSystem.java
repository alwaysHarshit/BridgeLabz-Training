package online.examination.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamManagementSystem {
    private List<Exam> exams;
    private Map<String, EvaluationStrategy> evaluationStrategies;

    public ExamManagementSystem() {
        this.exams = new ArrayList<>();
        this.evaluationStrategies = new HashMap<>();
        evaluationStrategies.put("OBJECTIVE", new ObjectiveEvaluation());
        evaluationStrategies.put("DESCRIPTIVE", new DescriptiveEvaluation());
    }

    public void createExam(Exam exam) {
        exams.add(exam);
        System.out.printf("✓ Successfully created exam: %s\n", exam.getExamName());
    }

    public Exam findExamById(int examId) {
        for (Exam exam : exams) {
            if (exam.getExamId() == examId) {
                return exam;
            }
        }
        return null;
    }

    public boolean updateExam(int examId, String newName, int newDuration) {
        Exam exam = findExamById(examId);
        if (exam != null) {
            exam.setExamName(newName);
            exam.setDurationMinutes(newDuration);
            System.out.printf("✓ Updated exam details for: %s\n", newName);
            return true;
        }
        System.out.println("✗ Exam not found with ID: " + examId);
        return false;
    }

    public boolean deleteExam(int examId) {
        Exam exam = findExamById(examId);
        if (exam != null) {
            exams.remove(exam);
            System.out.printf("✓ Deleted exam: %s\n", exam.getExamName());
            return true;
        }
        System.out.println("✗ Cannot delete. Exam not found with ID: " + examId);
        return false;
    }

    public void listAllExams() {
        if (exams.isEmpty()) {
            System.out.println("No exams available in the system.");
            return;
        }
        System.out.println("\n=== All Exams ===");
        int count = 1;
        while (count <= exams.size()) {
            System.out.println(count + ". " + exams.get(count - 1));
            count++;
        }
    }

    public void submitExam(Exam exam, Student student, long timeTakenMinutes) throws ExamTimeExpiredException {
        if (timeTakenMinutes > exam.getDurationMinutes()) {
            long excessTime = timeTakenMinutes - exam.getDurationMinutes();
            throw new ExamTimeExpiredException(exam.getExamId(), student.getName(), excessTime);
        }
        student.markAsSubmitted();
        System.out.printf("✓ %s submitted the exam within time limit (%d minutes)\n",
            student.getName(), timeTakenMinutes);
    }

    public void evaluateAndGenerateResult(Exam exam, Student student) {
        if (!student.hasSubmitted()) {
            System.out.printf("Cannot evaluate. %s hasn't submitted the exam yet.\n", student.getName());
            return;
        }

        int totalScore = 0;
        System.out.printf("\n=== Evaluating %s's Answers ===\n", student.getName());

        for (Question question : exam.getQuestions()) {
            String submittedAnswer = student.getAnswer(question.getQuestionId());
            EvaluationStrategy strategy = evaluationStrategies.get(question.getQuestionType().toUpperCase());

            if (strategy != null) {
                int earnedMarks = strategy.evaluate(question, submittedAnswer);
                totalScore += earnedMarks;
                System.out.printf("Q%d [%s]: %d/%d marks\n",
                    question.getQuestionId(), question.getQuestionType(), earnedMarks, question.getMarks());
            }
        }

        student.setTotalScore(totalScore);
        double percentage = (totalScore * 100.0) / exam.getTotalMarks();
        System.out.printf("\n--- Final Result for %s ---\n", student.getName());
        System.out.printf("Total Score: %d/%d (%.2f%%)\n", totalScore, exam.getTotalMarks(), percentage);
        System.out.printf("Grade: %s\n", determineGrade(percentage));
    }

    private String determineGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B+";
        else if (percentage >= 60) return "B";
        else if (percentage >= 50) return "C";
        else if (percentage >= 40) return "D";
        else return "F";
    }

    public List<Exam> getAllExams() {
        return exams;
    }
}
