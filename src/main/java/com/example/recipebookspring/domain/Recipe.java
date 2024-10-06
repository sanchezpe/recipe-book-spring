package com.example.recipebookspring.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "recipes")
@Getter
@Setter
public class Recipe {
    @Id
    private String id;
    private String name;
    private String description;
    private String imagePath;
    private List<Ingredient> ingredients = new ArrayList<>();
}
