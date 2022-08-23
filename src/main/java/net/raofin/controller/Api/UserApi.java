package net.raofin.controller.Api;

import net.raofin.dao.UserDao;
import net.raofin.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class UserApi
{
    private final UserDao userDao;

    public UserApi(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/fetchAllUsers")
    List<User> fetchUsersByUsers() {
        return userDao.fetchAllUsers();
    }

    @GetMapping("/fetchUserByUsername/{username}")
    User fetchUserByUsers(@PathVariable String username) {
        return userDao.fetchUserByUsername(username);
    }

    @GetMapping("/fetchUserById/{id}")
    User fetchUserById(@PathVariable String id) {
        return userDao.fetchUserById(Integer.parseInt(id));
    }

    @GetMapping("/deleteUserByUsername/{username}")
    void deleteUserByUsername(@PathVariable String username) {
        userDao.deleteUser(username);
    }

    @GetMapping("/disableUser/{id}")
    void disableUser(@PathVariable int id) {
        userDao.disableUser(id);
    }

    @GetMapping("/enableUser/{id}")
    void enableUser(@PathVariable int id) {
        userDao.enableUser(id);
    }

    @GetMapping("/makeAdmin/{id}")
    void makeAdmin(@PathVariable int id) {
        userDao.makeAdmin(id);
    }
}
