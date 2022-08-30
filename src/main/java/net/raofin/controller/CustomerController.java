package net.raofin.controller;

import net.raofin.model.User;
import net.raofin.service.FoodService;
import net.raofin.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@Controller
//@RequestMapping("/customer")
public class CustomerController
{
    public final UserService userService;
    public final FoodService foodService;

    public CustomerController(UserService userService, FoodService foodService) {
        this.userService = userService;
        this.foodService = foodService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping(value = "/profile", method = {RequestMethod.GET, RequestMethod.POST})
    public String showProfilePage(Principal principal, Model model) {

        User user = userService.fetchUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "customer/Profile";
    }

    @RequestMapping(value = "/profile-modify", method = {RequestMethod.GET, RequestMethod.POST})
    public String showProfileModifyPage(Principal principal, Model model) {

        User user = userService.fetchUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "customer/ProfileModify";
    }

    @RequestMapping("/profile-modify-action")
    public String profileModifyAction(@Valid @ModelAttribute("user") User updatedUser, BindingResult bindingResult, Principal principal) {

        if (bindingResult.hasFieldErrors("email") || bindingResult.hasFieldErrors("password")
                || bindingResult.hasFieldErrors("phoneNumber")) {
            return "redirect:/profile-modify?error";
        }

        User user = userService.fetchUserByUsername(principal.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        userService.updateUser(user);

        return "redirect:/profile?updated";
    }

    @RequestMapping(value = "/payment/{foodId}", method = {RequestMethod.GET, RequestMethod.POST})
    public String showPaymentPage(@PathVariable int foodId, Model model, HttpSession session) {

        model.addAttribute("food", foodService.fetchFoodByID(foodId));
        session.setAttribute("price", foodService.fetchFoodByID(foodId).getPrice());
        return "customer/Payment";
    }

    @GetMapping("/fetchUserById/{id}")
    User fetchUserById(@PathVariable String id) {
        return userService.fetchUserById(Integer.parseInt(id));
    }
}