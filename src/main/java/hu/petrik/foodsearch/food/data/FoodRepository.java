package hu.petrik.foodsearch.food.data;

import hu.petrik.foodsearch.food.data.Food;
import lombok.Builder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    Optional<Food> findFoodByName(String name);

    Page<Food> findFoodsByNameContainingIgnoreCase(String name, PageRequest pageRequest);
    Page<Food> findFoodsByCalorieBetween(Integer calorie, Integer calorie2, PageRequest pageRequest);
    Page<Food> findByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndCalorieBetween(String name, String description, Integer minCalorie, Integer maxCalorie, PageRequest pageRequest);
}
