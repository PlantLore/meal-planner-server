package com.davis.mealplanner.exceptions;

public abstract class IdNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 90156412092627659L;

    public IdNotFoundException() {
        super();
    }

    public IdNotFoundException(String resourceType, int id, Throwable cause) {
        super(resourceType + " By Id: " + id + " Not Found", cause);
    }

    public IdNotFoundException(String resourceType, int id) {
        super(resourceType + " By Id: " + id + " Not Found");
    }
}
