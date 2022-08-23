package net.raofin.service;

import net.raofin.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService
{
    List<User> fetchAllUsers();

    void registerUser(User user);

    User fetchUserById(int id);

    User fetchUserByUsername(String username);

    User fetchUserByEmail(String email);

    void updateUser(User user);

    void deleteUser(String email);

    void disableUser(int id);

    void enableUser(int id);

    void makeAdmin(int id);

    void makePayment(int id);

    List<User> searchUserByEmail(String email);


}
