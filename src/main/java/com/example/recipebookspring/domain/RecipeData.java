package com.example.recipebookspring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class RecipeData {
    private String name;
    private String description;
    private String imagePath;
    private List<Ingredient> ingredients = new ArrayList<>();
}
