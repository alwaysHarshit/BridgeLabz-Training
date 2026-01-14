package online.examination.system;

public class ExamTimeExpiredException extends Exception {
    private int examId;
    private String studentName;
    private long elapsedTime;

    public ExamTimeExpiredException(int examId, String studentName, long elapsedTime) {
        super(String.format("Exam time expired! Student '%s' exceeded the time limit for Exam #%d by %d minutes",
            studentName, examId, elapsedTime));
        this.examId = examId;
        this.studentName = studentName;
        this.elapsedTime = elapsedTime;
    }

    public int getExamId() {
        return examId;
    }

    public String getStudentName() {
        return studentName;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }
}
