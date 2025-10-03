package com.davis.mealplanner.exceptions;

public class IllegalMealTypeException extends IllegalArgumentException {

    public IllegalMealTypeException(String illegalMealType) {
        super("Illegal meal type: " + illegalMealType);
    }
}
