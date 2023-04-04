package hu.petrik.foodsearch.food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Data
public class BadFoodSearchArgumentException extends RuntimeException {

    private String message;
    private int statusCode;

    public BadFoodSearchArgumentException(String message) {
        super();
        this.message = message;
    }
    public BadFoodSearchArgumentException() {
        super();
        this.message = "Wrong argument";
    }


}
