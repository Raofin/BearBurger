package net.raofin.controller;

import net.raofin.model.Food;
import net.raofin.service.FoodService;
import net.raofin.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/admin")
public class AdminController
{
    public final FoodService foodService;
    public final UserService userService;

    public AdminController(FoodService foodService, UserService userService) {
        this.foodService = foodService;
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public String showDashboardPage() {
        return "admin/Dashboard";
    }

    @RequestMapping(value = "/manage-user", method = {RequestMethod.GET, RequestMethod.POST})
    public String showManageUserPage() {
        return "admin/ManageUser";
    }

    @RequestMapping(value = "/add-user", method = {RequestMethod.GET, RequestMethod.POST})
    public String showAddUserPage() {
        return "admin/AddUser";
    }

    @RequestMapping(value = "/add-food", method = {RequestMethod.GET, RequestMethod.POST})
    public String showAddFoodPage() {
        return "admin/AddFood";
    }

    @RequestMapping(value = "saveFood", method = {RequestMethod.GET, RequestMethod.POST})
    public String newFood(@Validated @ModelAttribute Food food, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/AddFood";
        }

        food = setupFoodForm();
        foodService.addFood(food);
        return "redirect:/admin/Dashboard";
    }

    @Validated
    @ModelAttribute
    public Food setupFoodForm() {
        return new Food();
    }
}
