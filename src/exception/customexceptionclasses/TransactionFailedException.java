package exception.customexceptionclasses;

public class TransactionFailedException extends Exception {

    public TransactionFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
