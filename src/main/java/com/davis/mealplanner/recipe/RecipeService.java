package com.davis.mealplanner.recipe;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davis.mealplanner.models.Recipe;

@Service
public class RecipeService {
    
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }
}
