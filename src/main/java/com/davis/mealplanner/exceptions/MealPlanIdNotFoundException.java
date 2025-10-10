package com.davis.mealplanner.exceptions;

public class MealPlanIdNotFoundException extends IdNotFoundException {
    private static final String RESOURCE_TYPE = "MealPlan";

    public MealPlanIdNotFoundException() {
        super();
    }

    public MealPlanIdNotFoundException(int id, Throwable cause) {
        super(RESOURCE_TYPE, id, cause);
    }

    public MealPlanIdNotFoundException(int id) {
        super(RESOURCE_TYPE, id);
    }
}
