package com.davis.mealplanner.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recipe")
public class Recipe {
    @Id
    @Column(name = "recipe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "servings", nullable = false)
    private int servings;

    @Column(name = "calories", nullable = false)
    private int calories;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "creator_email", nullable = false)
    private String creatorEmail;
    
    @ManyToMany
    private List<RecipeType> recipeTypes;

    @OneToOne
    @JoinColumn(name = "archived_recipe_id", referencedColumnName = "recipe_id")
    private Recipe updatedRecipe;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    private List<Step> steps;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    private List<Ingredient> ingredients;
}
