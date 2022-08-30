package net.raofin.controller.Api;

import net.raofin.model.Food;
import net.raofin.model.User;
import net.raofin.service.FoodService;
import net.raofin.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodApi
{
    private final FoodService foodService;
    private final UserService userService;

    public FoodApi(FoodService foodService, UserService userService) {
        this.foodService = foodService;
        this.userService = userService;
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

    @GetMapping("/payment-action")
    void paymentAction(Principal principal, HttpSession session) {

        User user = userService.fetchUserByUsername(principal.getName());
        user.setSpent(user.getSpent() + Integer.parseInt(session.getAttribute("price").toString()));
        userService.updateUser(user);
        session.removeAttribute("price");
    }
}