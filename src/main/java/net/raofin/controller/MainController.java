package net.raofin.controller;

import net.raofin.dao.FoodDao;
import net.raofin.dao.UserDao;
import net.raofin.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController
{
    private final UserDao userDao;

    private final FoodDao foodDao;

    public MainController(UserDao userDao, FoodDao foodDao) {
        this.userDao = userDao;
        this.foodDao = foodDao;
    }

    @GetMapping("/")
    public String showWelcomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "Login";
    }

    @GetMapping("/register")
    public String showRegisterPage(@ModelAttribute("user") User user) {
        return "Register";
    }

    @RequestMapping("/register-action")
    public String register(@ModelAttribute("user") User user, BindingResult bindingResult) {
        System.out.println(foodDao.fetchAllFoods());
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            System.out.println(bindingResult.hasErrors());
            return "register";
        }
//        userDao.registerUser(user);
        System.out.println(user);

        return "redirect:/register";
    }

    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public String showHomePage() {
        return "Home";
    }

    @GetMapping("/403")
    public String showDeniedPage() {
        return "403";
    }
}
