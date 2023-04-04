package hu.petrik.foodsearch.food;

import hu.petrik.foodsearch.food.data.Food;
import hu.petrik.foodsearch.food.dto.FoodSearchQuery;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/food")
@RequiredArgsConstructor
@Slf4j
public class FoodController {
    private final FoodService foodService;

    @PostMapping("")
    public ResponseEntity<List<Food>> getAllFood(@Valid @RequestBody FoodSearchQuery foodSearchQuery) {
        PageRequest pageRequest = PageRequest.of(foodSearchQuery.getPage(), foodSearchQuery.getSize(), Sort.by(foodSearchQuery.getSortBy().getUnit()));
        if (foodSearchQuery.getReversed() != null && foodSearchQuery.getReversed()) {
            pageRequest.withSort(pageRequest.getSort().descending());
        }
        List<Food> foods = foodService.getFoodsFiltered(foodSearchQuery, pageRequest);
        return ResponseEntity.ok(foods);
    }
}
