package org.senla.exception;

/**
 * Класс-исклучение для отслеживания попытки доступа по неверному Id
 * @author Максим Ведеников
 * */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}