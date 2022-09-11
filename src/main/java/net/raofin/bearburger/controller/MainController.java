package net.raofin.bearburger.controller;

import net.raofin.bearburger.model.User;
import net.raofin.bearburger.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Objects;

@Controller
public class MainController
{
    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showWelcomePage() {
        return "index";
    }

    @GetMapping("/login-success")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN"))
            return "redirect:/dashboard";

        return "redirect:/home";
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
    public String showLoginPage(Principal principal) {

        if (principal != null)
            return "redirect:/home";

        return "Login";
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String showRegisterPage(@ModelAttribute("user") User user,
                                   Principal principal) {

        if (principal != null)
            return "redirect:/home";

        return "Register";
    }

    @RequestMapping("/register-action")
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors() || !Objects.equals(user.getPassword(), user.getcPassword()))
            return "redirect:/register?error";

        if(userService.fetchUserByUsername(user.getUsername()) != null)
            return "redirect:/register?duplicate";

        userService.registerUser(user);

        return "redirect:/login?regSuccess";
    }

    @GetMapping("/403")
    public String showDeniedPage() {
        return "403";
    }

    @GetMapping("/project-details")
    public String showDetailsPage() {
        return "ProjectDetails";
    }
}
