package net.raofin.bearburger.controller;

import net.raofin.bearburger.model.Food;
import net.raofin.bearburger.model.User;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/admin")
public class AdminController
{
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public String showDashboardPage() {
        return "admin/Dashboard";
    }

    @RequestMapping(value = "/manage-roles", method = {RequestMethod.GET, RequestMethod.POST})
    public String showManageRolesPage() {
        return "admin/ManageRoles";
    }

    @RequestMapping(value = "/manage-user", method = {RequestMethod.GET, RequestMethod.POST})
    public String showManageUserPage() {
        return "admin/ManageUser";
    }

    @RequestMapping(value = "/add-user", method = {RequestMethod.GET, RequestMethod.POST})
    public String showAddUserPage(@ModelAttribute(value = "user") User user) {
        return "admin/AddUser";
    }

    @RequestMapping(value = "/manage-food", method = {RequestMethod.GET, RequestMethod.POST})
    public String showManageFoodPage() {
        return "admin/ManageFood";
    }

    @RequestMapping(value = "/add-food", method = {RequestMethod.GET, RequestMethod.POST})
    public String showAddFoodPage(@ModelAttribute("food") Food food) {
        return "admin/AddFood";
    }
}
