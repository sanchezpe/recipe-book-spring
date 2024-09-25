package com.example.recipebookspring.repository;

import com.example.recipebookspring.domain.Recipe;
import com.example.recipebookspring.domain.RecipeProjection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource(excerptProjection = RecipeProjection.class)
public interface RecipeRepository extends MongoRepository<Recipe, String> {
    void deleteAllByIdNotIn(Set<String> incomingRecipeIds);
}
