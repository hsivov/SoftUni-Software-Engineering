package bg.softuni.springAdvanced.services;

import bg.softuni.springAdvanced.entities.Ingredient;
import bg.softuni.springAdvanced.repositories.IngredientsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientsRepository ingredientRepository;

    public IngredientServiceImpl(IngredientsRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findByName(String name) {
        return ingredientRepository.findByNameStartingWith(name);
    }

    @Override
    public List<Ingredient> findByNameWithin(List<String> names) {
        return ingredientRepository.findByNameInOrderByPriceAsc(names);
    }
}
