package com.davis.mealplanner.models;

import com.davis.mealplanner.exceptions.IllegalMealTypeException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MealType {
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SNACK("Snack"),
    SWEET_TREAT("Sweet Treat");

    private final String value;

    MealType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static MealType fromString(String s) {
        if (s == null) return null;
        try {
            return MealType.valueOf(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            for (MealType t : MealType.values()) {
                if (t.value.equalsIgnoreCase(s)) return t;
            }
            throw new IllegalMealTypeException(s);
        }
    }
}
