package exception.customexceptionclasses;

public class FileMissingException extends Exception {

    private String message;

    public FileMissingException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
