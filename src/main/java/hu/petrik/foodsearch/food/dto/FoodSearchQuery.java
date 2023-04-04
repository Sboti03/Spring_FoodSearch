package hu.petrik.foodsearch.food.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hu.petrik.foodsearch.food.data.SortEnum;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodSearchQuery {

    @Nullable
    private String name;

    @Min(0)
    private Integer minKcal;

    @Min(0)
    private Integer maxKcal;

    @Nullable
    private String description;

    @Min(0)
    @NotNull
    private Integer page = 0;

    @NotNull
    @Min(1)
    private Integer size = 10;

    @Generated
    @JsonProperty("sort-by")
    private SortEnum sortBy = SortEnum.NAME;

    @Nullable
    private Boolean reversed;




    public void setSortBy(String sortBy) {
        this.sortBy = SortEnum.valueOf(sortBy.toUpperCase());
    }


}
