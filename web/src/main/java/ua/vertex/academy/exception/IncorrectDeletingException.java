package ua.vertex.academy.exception;

/**
 * Created by RASTA on 20.05.2016.
 */
public class IncorrectDeletingException extends RuntimeException {
    public IncorrectDeletingException() {
        super();
    }

    public IncorrectDeletingException(String message) {
        super(message);
    }
}
