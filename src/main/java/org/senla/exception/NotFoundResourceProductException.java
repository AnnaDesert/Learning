package org.senla.exception;

public class NotFoundResourceProductException extends RuntimeException {
    public NotFoundResourceProductException(String message) {
        super(message);
    }
}
