package Exceptions;

public class InvalidFilePathException extends FrameworkExceptions{
    public InvalidFilePathException(String message) {
        super(message);
    }

    public InvalidFilePathException(String message, Throwable cause) {
        super(message, cause);
    }
}
