package net.raofin.bearburger.controller;

import net.raofin.bearburger.model.Food;
import net.raofin.bearburger.model.User;
import net.raofin.bearburger.service.FoodService;
import net.raofin.bearburger.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FoodController
{
    private final FoodService foodService;
    private final UserService userService;

    public FoodController(FoodService foodService, UserService userService) {
        this.foodService = foodService;
        this.userService = userService;
    }

    @GetMapping("/fetch-all-foods")
    List<Food> allFoods() {
        return foodService.fetchAllFoods();
    }

    @GetMapping("/fetch-foods-by-category/{category}")
    List<Food> fetchFoodsByCategory(@PathVariable String category) {
        return foodService.fetchFoodByCategory(category);
    }

    @GetMapping("/search-foods-by-name")
    List<Food> searchFoods(@RequestParam("name") String name) {
        return foodService.searchFoodByTitle(name);
    }

    @GetMapping("/payment-action")
    void paymentAction(Principal principal, HttpSession session) {

        User user = userService.fetchUserByUsername(principal.getName());
        user.setSpent(user.getSpent() + Integer.parseInt(session.getAttribute("price").toString()));
        userService.updateUser(user);
        session.removeAttribute("price");
    }
}