package online.examination.system;

public class Question {
    private int questionId;
    private String questionText;
    private String questionType;
    private String correctAnswer;
    private int marks;

    public Question(int questionId, String questionText, String questionType, String correctAnswer, int marks) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.questionType = questionType;
        this.correctAnswer = correctAnswer;
        this.marks = marks;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getMarks() {
        return marks;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return String.format("Q%d [%s] (%d marks): %s", questionId, questionType, marks, questionText);
    }
}
