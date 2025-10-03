package com.davis.mealplanner.models.dtos;

import java.util.List;

import com.davis.mealplanner.models.Ingredient;
import com.davis.mealplanner.models.Recipe;
import com.davis.mealplanner.models.RecipeType;
import com.davis.mealplanner.models.Step;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {
    private int id;
    private String title;
    private int servings;
    private int calories;
    private String image;
    private String creatorEmail;
    private List<RecipeType> recipeTypes;
    private boolean archived;
    private List<Step> steps;
    private List<Ingredient> ingredients;

    RecipeDTO( Recipe recipe ) {
        id = recipe.getId();
        title = recipe.getTitle();
        servings = recipe.getServings();
        calories = recipe.getCalories();
        image = recipe.getImage();
        creatorEmail = recipe.getCreatorEmail();
        recipeTypes = recipe.getRecipeTypes();
        archived = recipe.isArchived();
        steps = recipe.getSteps();
        ingredients = recipe.getIngredients();
    };
}
