package bg.softuni.springAdvanced.services;

import bg.softuni.springAdvanced.entities.Shampoo;
import bg.softuni.springAdvanced.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {

    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, Size size);

    List<Shampoo> findBySize(Size size);

    List<Shampoo> findBySizeOrLabelId(Size medium, long labelId);

    List<Shampoo> findByPriceGreaterThan(BigDecimal price);

    int findCheaperThanCount(BigDecimal price);

    List<Shampoo> findAllShampoosWithIngredients(List<String> ingredientNames);
}
