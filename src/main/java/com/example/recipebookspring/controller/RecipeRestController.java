package com.example.recipebookspring.controller;

import com.example.recipebookspring.domain.Recipe;
import com.example.recipebookspring.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recipes/batch")
@RequiredArgsConstructor
public class RecipeRestController {
    private final RecipeRepository recipeRepository;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    void batchUpdateRecipes(@RequestBody List<Recipe> recipes) {
        recipeRepository.saveAll(recipes);

        Set<String> toKeepIds = recipes.stream()
                .map(Recipe::getId)
                .collect(Collectors.toSet());

        recipeRepository.deleteAllByIdNotIn(toKeepIds);
    }
}
