package net.raofin.controller;

import net.raofin.dao.FoodDao;
import net.raofin.dao.UserDao;
import net.raofin.model.Food;
import net.raofin.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Testing
{
    private final UserDao userDao;
    private final FoodDao foodDao;

    public Testing(UserDao userDao, FoodDao foodDao) {
        this.userDao = userDao;
        this.foodDao = foodDao;
    }

    @GetMapping("/u")
    List<User> allUsers() {
        return userDao.fetchAllUsers();
    }

    @GetMapping("/f")
    List<Food> allFoods() {
        return foodDao.fetchAllFoods();
    }
}
