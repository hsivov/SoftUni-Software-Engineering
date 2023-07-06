package bg.softuni.springAdvanced.repositories;

import bg.softuni.springAdvanced.entities.Ingredient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameStartingWith(String name);

    List<Ingredient> findByNameInOrderByPriceAsc(List<String> names);

    @Transactional
    void deleteIngredientByName(String name);
}
