package com.davis.mealplanner.models.dtos;

import com.davis.mealplanner.models.Recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeLabel {
    private Integer id;
    private String label;

    RecipeLabel(Recipe recipe) {
        this.id = recipe.getId();
        this.label = recipe.getTitle();
    }
}
