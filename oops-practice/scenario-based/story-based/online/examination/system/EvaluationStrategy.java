package online.examination.system;

public interface EvaluationStrategy {
    int evaluate(Question question, String submittedAnswer);
    String getStrategyName();
}
