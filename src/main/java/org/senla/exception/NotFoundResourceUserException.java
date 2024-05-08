package org.senla.exception;

public class NotFoundResourceUserException extends RuntimeException {
    public NotFoundResourceUserException(String message) {
        super(message);
    }
}
