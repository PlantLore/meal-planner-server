package com.davis.mealplanner.models;

import com.davis.mealplanner.exceptions.IllegalMealTypeException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MealType {
    BREAKFAST,
    LUNCH,
    DINNER,
    SNACK,
    SWEET_TREAT;

    @JsonValue
    public String toValue() {
        return this.name();
    }

    @JsonCreator
    public static MealType fromString(String value) {
        if (value == null) return null;
        try {
            return MealType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalMealTypeException(value);
        }
    }

    public String toDTOValue() {
        switch(this) {
            case BREAKFAST: return "Breakfast";
            case LUNCH: return "Lunch";
            case DINNER: return "Dinner";
            case SNACK: return "Snack";
            case SWEET_TREAT: return "Dessert";
            default: throw new IllegalMealTypeException(this.name());
        }
    }
}
