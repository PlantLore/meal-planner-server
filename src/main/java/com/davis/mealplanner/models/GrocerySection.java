package com.davis.mealplanner.models;

import com.davis.mealplanner.exceptions.IllegalGrocerySectionException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum GrocerySection {
    PRODUCE,
    DELI,
    MEAT,
    SEAFOOD,
    BAKERY,
    FROZEN_FOODS,
    DAIRY,
    INNER_AISLES,
    OTHER;

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
            throw new IllegalGrocerySectionException(value);
        }
    }

    public String toDTOValue() {
        switch(this) {
            case PRODUCE: return "Produce";
            case DELI: return "Deli";
            case MEAT: return "Meat";
            case SEAFOOD: return "Seafood";
            case BAKERY: return "Bakery";
            case FROZEN_FOODS: return "Frozen Foods";
            case DAIRY: return "Dairy"; 
            case INNER_AISLES: return "Inner Aisles";
            case OTHER: return "Other";
            default: throw new IllegalGrocerySectionException(this.name());
        }
    }
}
