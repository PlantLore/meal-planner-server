package com.davis.mealplanner.exceptions;

public class IllegalGrocerySectionException extends IllegalArgumentException  {
    
    public IllegalGrocerySectionException(String illegalGrocerySection) {
        super("Illegal grocery section: " + illegalGrocerySection);
    }
}
