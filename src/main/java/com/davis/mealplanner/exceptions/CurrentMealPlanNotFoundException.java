package com.davis.mealplanner.exceptions;

public class CurrentMealPlanNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 90156412092627673L;

    public CurrentMealPlanNotFoundException() {
        super("Current Meal Plan Not Found");
    }

    public CurrentMealPlanNotFoundException(int id, Throwable cause) {
        super("Current Meal Plan Not Found", cause);
    }
}
