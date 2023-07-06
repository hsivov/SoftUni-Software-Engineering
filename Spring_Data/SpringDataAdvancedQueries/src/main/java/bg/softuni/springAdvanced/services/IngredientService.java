package bg.softuni.springAdvanced.services;

import bg.softuni.springAdvanced.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findByName(String name);

    List<Ingredient> findByNameWithin(List<String> names);

    void deleteIngredient(String name);
}
