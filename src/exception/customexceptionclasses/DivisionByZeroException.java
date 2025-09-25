package exception.customexceptionclasses;

public class DivisionByZeroException extends Exception {

    private String message;

    public DivisionByZeroException(String message) {
        super(message);
    }
}
