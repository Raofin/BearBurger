package net.raofin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController
{
    @GetMapping("/")
    public String showWelcomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "Login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "Register";
    }

    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public String showHomePage() {
        return "Home";
    }

    @GetMapping("/accessDenied")
    public String showDeniedPage() {
        return "AccessDenied";
    }
}
