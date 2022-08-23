package net.raofin.controller;

import net.raofin.dao.UserDao;
import net.raofin.model.User;
import net.raofin.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class MainController
{
    private final UserDao userDao;
    private final UserService userService;

    public MainController(UserDao userDao, UserService userService) {
        this.userDao = userDao;
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public String showWelcomePage() {
        return "index";
    }

    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public String showHomePage() {
        return "Home";
    }

    @RequestMapping(value = "/search-foods", method = {RequestMethod.GET, RequestMethod.POST})
    public String showSearchFoodsPage() {
        return "SearchFoods";
    }

    @RequestMapping("/login")
    public String showLoginPage() {
        return "Login";
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String showRegisterPage(@ModelAttribute("user") User user) {
        return "Register";
    }

    @RequestMapping("/register-action")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors() || !Objects.equals(user.getPassword(), user.getcPassword()))
            return "redirect:/register?error";

        userService.registerUser(user);

        return "redirect:/register";
    }

    @GetMapping("/403")
    public String showDeniedPage() {
        return "403";
    }
}
