package com.example.recipebookspring.domain;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "recipeDto", types = Recipe.class)
public interface RecipeProjection {
    Long getId();

    String getName();

    String getDescription();

    String getImagePath();

    List<Ingredient> getIngredients();
}
