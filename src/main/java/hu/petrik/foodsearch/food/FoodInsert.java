package hu.petrik.foodsearch.food;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
@Slf4j
public class FoodInsert implements CommandLineRunner {

    private final FoodRepository foodRepository;
    @Override
    public void run(String... args) throws Exception {
        ReadFile();
    }

    @SneakyThrows
    private void ReadFile() {
        File file = new File("src/main/resources/food.csv");
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();

                // name;calorie;description;unit;perUnit
                String[] foodData = data.split(";");
                Food foodObj = Food.builder()
                        .name(foodData[0])
                        .calorie(Integer.valueOf(foodData[1]))
                        .description(foodData[2])
                        .unit(Unit.valueOf(foodData[3].toUpperCase()))
                        .perUnit(Integer.valueOf(foodData[4]))
                        .build();
                if (foodRepository.findFoodByName(foodObj.getName()).isEmpty()) {
                    foodRepository.save(foodObj);
                }
            }
        }
    }
}
