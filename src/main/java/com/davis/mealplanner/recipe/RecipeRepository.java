package com.davis.mealplanner.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davis.mealplanner.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    
}
