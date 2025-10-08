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
    DAIRY("Diary"),
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
        try {
            return GrocerySection.valueOf(s.toUpperCase());
        } catch (IllegalGrocerySectionException e) {
            for (GrocerySection t : GrocerySection.values()) {
                if (t.value.equalsIgnoreCase(s)) return t;
            }
            throw new IllegalGrocerySectionException(s);
        }
    }
}
