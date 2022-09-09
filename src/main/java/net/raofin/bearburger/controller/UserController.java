package net.raofin.bearburger.controller;

import net.raofin.bearburger.model.Food;
import net.raofin.bearburger.model.User;
import net.raofin.bearburger.service.FoodService;
import net.raofin.bearburger.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class UserController
{
    private final UserService userService;
    private final FoodService foodService;

    public UserController(UserService userService, FoodService foodService) {
        this.userService = userService;
        this.foodService = foodService;
    }

    @GetMapping("/fetch-all-users")
    List<User> fetchUsersByUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping("/fetch-user-by-username/{username}")
    User fetchUserByUsers(@PathVariable String username) {
        return userService.fetchUserByUsername(username);
    }

    @GetMapping("/fetch-user-by-id/{id}")
    User fetchUserById(@PathVariable String id) {
        return userService.fetchUserById(Integer.parseInt(id));
    }

    @GetMapping("/delete-user-by-username/{username}")
    void deleteUserByUsername(@PathVariable String username) {
        userService.deleteUser(username);
    }

    @GetMapping("/delete-user-by-id/{id}")
    void deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/disable-user/{id}")
    void disableUser(@PathVariable int id) {
        userService.disableUser(id);
    }

    @GetMapping("/enable-user/{id}")
    void enableUser(@PathVariable int id) {
        userService.enableUser(id);
    }

    @GetMapping("/make-admin/{id}")
    void makeAdmin(@PathVariable int id) {
        userService.makeAdmin(id);
    }

    @GetMapping("/remove-admin/{id}")
    void removeAdmin(@PathVariable int id) {
        userService.removeAdmin(id);
    }

    @GetMapping("/delete-food/{id}")
    void deleteFood(@PathVariable String id) {
        foodService.deleteById(Integer.parseInt(id));
    }

    @PostMapping("/add-user-action")
    String saveUser(@Valid @ModelAttribute(value = "user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "error";

        if (userService.fetchUserByUsername(user.getUsername()) != null)
            return "duplicate";

        userService.registerUser(user);

        return "added";
    }

    @PostMapping("/add-food-action")
    public String register(@Valid @ModelAttribute(value = "food") Food food, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "error";

        foodService.save(food);

        return "added";
    }
}
