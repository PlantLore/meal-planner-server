package com.davis.mealplanner.models;

import com.davis.mealplanner.exceptions.IllegalRecipeTypeException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RecipeType {
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SNACK("Snack"),
    SWEET_TREAT("Sweet Treat"),
    SIDE("Side"),
    FRUIT("Fruit"),
    VEGETABLE("Vegatable");

    private final String value;

    RecipeType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static RecipeType fromString(String s) {
        if (s == null) return null;
        String normalized = s.trim().replaceAll("[\\s-]+", "_").toUpperCase();
        try {
            return RecipeType.valueOf(normalized);
        } catch (IllegalArgumentException e) {
            for (RecipeType t : RecipeType.values()) {
                if (t.value.equalsIgnoreCase(s.trim())) return t;
            }
            throw new IllegalRecipeTypeException(s);
        }
    }
}
