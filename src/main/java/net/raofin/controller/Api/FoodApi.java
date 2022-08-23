package net.raofin.controller.Api;

import net.raofin.dao.FoodDao;
import net.raofin.model.Food;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodApi
{
    private final FoodDao foodDao;

    public FoodApi(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @GetMapping("/fetchFoods/{category}")
    List<Food> fetchFoodsByCategory(@PathVariable String category) {
        return foodDao.fetchFoodByCategory(category);
    }

    @GetMapping("/fetchAllFoods")
    List<Food> allFoods() {
        return foodDao.fetchAllFoods();
    }
}
