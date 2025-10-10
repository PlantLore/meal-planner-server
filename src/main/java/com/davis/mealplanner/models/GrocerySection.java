package com.davis.mealplanner.models;

import com.davis.mealplanner.exceptions.IllegalGrocerySectionException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum GrocerySection {
    PRODUCE("Produce"),
    DELI("Deli"),
    MEAT("Meat"),
    SEAFOOD("Seafood"),
    BAKERY("Bakery"),
    FROZEN_FOODS("Frozen Foods"),
    DAIRY("Dairy"),
    INNER_AISLES("Inner Aisles"),
    OTHER("Other");

    private final String value;

    GrocerySection(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static GrocerySection fromString(String s) {
        if (s == null) return null;
        String normalized = s.trim().replaceAll("[\\s-]+", "_").toUpperCase();
        try {
            return GrocerySection.valueOf(normalized);
        } catch (IllegalGrocerySectionException e) {
            for (GrocerySection t : GrocerySection.values()) {
                if (t.value.equalsIgnoreCase(s.trim())) return t;
            }
            throw new IllegalGrocerySectionException(s);
        }
    }
}
