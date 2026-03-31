package DisasterRelief;

public class InsufficientResourceException extends Exception {
    public InsufficientResourceException(String notEnoughQuanity) {
        super(notEnoughQuanity);
    }
}
