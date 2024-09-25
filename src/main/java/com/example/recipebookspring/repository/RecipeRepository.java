package com.example.recipebookspring.repository;

import com.example.recipebookspring.domain.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
}
