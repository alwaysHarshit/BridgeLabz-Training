package online.examination.system;

public class DescriptiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(Question question, String submittedAnswer) {
        if (submittedAnswer == null || submittedAnswer.trim().isEmpty()) {
            return 0;
        }

        String correctAns = question.getCorrectAnswer().toLowerCase();
        String studentAns = submittedAnswer.toLowerCase();
        int maxMarks = question.getMarks();

        String[] keywords = correctAns.split("\\s+");
        int matchedKeywords = 0;

        for (String keyword : keywords) {
            if (studentAns.contains(keyword)) {
                matchedKeywords++;
            }
        }

        double matchPercentage = (double) matchedKeywords / keywords.length;
        int earnedMarks = (int) (matchPercentage * maxMarks);

        return earnedMarks;
    }

    @Override
    public String getStrategyName() {
        return "Descriptive (Keyword-based)";
    }
}
