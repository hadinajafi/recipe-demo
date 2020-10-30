package guru.springframework.recipedemo.services;

import guru.springframework.recipedemo.models.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
