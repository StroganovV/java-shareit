package ru.yandex.practicum.ShareIt.exceptions;

public class IncorrectUserException extends RuntimeException {
    public IncorrectUserException(String message) {
        super(message);
    }
}
