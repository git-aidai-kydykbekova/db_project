package org.example.dp_project.utils.exception;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String objectName) {
        super(objectName + " is not found");
    }
}
