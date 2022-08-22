package net.raofin.controller;

import net.raofin.model.User;
import net.raofin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
//@RequestMapping("/customer")
public class CustomerController
{
    public final UserService userService;

    public CustomerController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showProfilePage(Principal principal, Model model) {
        User user = userService.fetchUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "customer/Profile";
    }

    @RequestMapping(value = "/profile-modify", method = {RequestMethod.GET, RequestMethod.POST})
    public String showProfileModifyPage() {
        return "customer/ProfileModify";
    }

    @RequestMapping(value = "/payment", method = {RequestMethod.GET, RequestMethod.POST})
    public String showPaymentPage() {
        return "customer/Payment";
    }

    /*@RequestMapping("/register-action")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors() || !Objects.equals(user.getPassword(), user.getcPassword()))
            return "redirect:/register?error";

        userDao.registerUser(user);

        return "redirect:/register";
    }*/





    /*@RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public String showHomePage() {
        return "Home";
    }*/
}
