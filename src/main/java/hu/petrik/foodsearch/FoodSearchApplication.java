package hu.petrik.foodsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class FoodSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodSearchApplication.class, args);
    }

}
