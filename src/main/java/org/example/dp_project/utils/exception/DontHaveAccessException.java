package org.example.dp_project.utils.exception;

public class DontHaveAccessException extends RuntimeException{
    public DontHaveAccessException() {
        super("You cannot do that because you don't have access.");
    }
}
