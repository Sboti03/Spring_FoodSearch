package hu.petrik.foodsearch.food.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SortEnum {
    NAME("name"),
    CALORIE("calorie"),
    DESCRIPTION("description"),
    PER_UNIT("per_unit"),
    UNIT("unit"),
    ;

    private final String unit;


}

