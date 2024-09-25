package com.example.recipebookspring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity(name = "recipe")
@Getter
@Setter
public class Recipe {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(name = "recipe_data", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    @JsonIgnore
    private RecipeData recipeData = new RecipeData();

    public String getName() {
        return recipeData.getName();
    }

    public void setName(String name) {
        this.recipeData.setName(name);
    }

    public String getDescription() {
        return recipeData.getDescription();
    }

    public void setDescription(String description) {
        this.recipeData.setDescription(description);
    }

    public String getImagePath() {
        return recipeData.getImagePath();
    }

    public void setImagePath(String imagePath) {
        this.recipeData.setImagePath(imagePath);
    }

    public List<Ingredient> getIngredients() {
        return recipeData.getIngredients();
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.recipeData.setIngredients(ingredients);
    }

}
