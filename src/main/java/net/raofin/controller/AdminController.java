package net.raofin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @RequestMapping("/dashboard")
    public String showDashboardPage() {
        return "admin/Dashboard";
    }

    @RequestMapping("/addFood")
    public String showAddFoodPage() {
        return "admin/AddFood";
    }

    @RequestMapping("/addUser")
    public String showAddUserPage() {
        return "admin/AddUser";
    }

    @RequestMapping("/manageUser")
    public String showPage() {
        return "admin/ManageUser";
    }
}
