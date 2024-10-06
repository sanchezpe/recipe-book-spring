package com.example.recipebookspring.repository;

import com.example.recipebookspring.domain.Recipe;
import com.example.recipebookspring.domain.RecipeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RepositoryRestResource(excerptProjection = RecipeProjection.class)
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Transactional
    @Modifying
    void deleteAllByIdNotIn(Set<Long> incomingRecipeIds);
}
