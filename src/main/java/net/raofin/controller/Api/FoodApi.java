package net.raofin.controller.Api;

import net.raofin.model.Food;
import net.raofin.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodApi
{
    private final FoodService foodService;

    public FoodApi(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/fetchFoods/{category}")
    List<Food> fetchFoodsByCategory(@PathVariable String category) {
        return foodService.fetchFoodByCategory(category);
    }

    @GetMapping("/fetchAllFoods")
    List<Food> allFoods() {
        return foodService.fetchAllFoods();
    }

    @GetMapping("/searchFoods")
    List<Food> searchFoods(@RequestParam("name") String name) {
        return foodService.searchFoodByTitle(name);
    }

    @GetMapping("/delete-food/{id}")
    void deleteFood(@PathVariable String id) {
        foodService.deleteFoodById(Integer.parseInt(id));
    }
}
