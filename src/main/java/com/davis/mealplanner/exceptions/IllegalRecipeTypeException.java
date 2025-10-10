package com.davis.mealplanner.exceptions;

public class IllegalRecipeTypeException extends IllegalArgumentException {

    public IllegalRecipeTypeException(String illegalRecipeType) {
        super("Illegal recipe type: " + illegalRecipeType);
    }
}
