package Exceptions;

public class InputOutputException extends  FrameworkExceptions{
    public InputOutputException(String message) {
        super(message);
    }

    public InputOutputException(String message, Throwable cause) {
        super(message, cause);
    }
}
