package online.examination.system;

public class ObjectiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(Question question, String submittedAnswer) {
        if (submittedAnswer == null || submittedAnswer.trim().isEmpty()) {
            return 0;
        }

        String correctAns = question.getCorrectAnswer().trim().toLowerCase();
        String studentAns = submittedAnswer.trim().toLowerCase();

        return correctAns.equals(studentAns) ? question.getMarks() : 0;
    }

    @Override
    public String getStrategyName() {
        return "Objective (Auto-graded)";
    }
}
