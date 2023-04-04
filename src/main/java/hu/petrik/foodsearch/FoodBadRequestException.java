package hu.petrik.foodsearch;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FoodBadRequestException extends RuntimeException {
    public FoodBadRequestException() {
        super("Bad food search param");
    }
}