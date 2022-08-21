package net.raofin.controller;

import net.raofin.dao.UserDao;
import net.raofin.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Testing
{
    private final UserDao userDao;

    public Testing(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/z")
    List<User> all() {
        return userDao.fetchAllUsers();
    }
}
