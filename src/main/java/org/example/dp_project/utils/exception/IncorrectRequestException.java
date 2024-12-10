package org.example.dp_project.utils.exception;

public class IncorrectRequestException extends RuntimeException {
    public IncorrectRequestException(String parameter) {
        super("You need to provide " + parameter);
    }
}
