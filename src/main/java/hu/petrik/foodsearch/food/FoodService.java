package hu.petrik.foodsearch.food;


import hu.petrik.foodsearch.food.data.Food;
import hu.petrik.foodsearch.food.data.FoodRepository;
import hu.petrik.foodsearch.food.dto.FoodSearchQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class FoodService {



    private final FoodRepository foodRepository;

    public List<Food> getFoodsFiltered(FoodSearchQuery foodSearchQuery, PageRequest pageRequest) {

        Stream<Food> foodStream = foodRepository.findAll(pageRequest).stream();

        if (foodSearchQuery.getName() != null) {
            foodStream = foodStream.filter(food -> food.getName().contains(foodSearchQuery.getName()));
        }


        if (foodSearchQuery.getMinKcal() != null) {
            foodStream = foodStream.filter(food -> food.getCalorie() >= foodSearchQuery.getMinKcal());
        }

        if (foodSearchQuery.getMaxKcal() != null) {
            foodStream = foodStream.filter(food -> food.getCalorie() <= foodSearchQuery.getMaxKcal());
        }

        if (foodSearchQuery.getDescription() != null) {
            foodStream = foodStream.filter(food -> food.getDescription().contains(foodSearchQuery.getDescription()));
        }

        return foodStream.toList();
    }
}
