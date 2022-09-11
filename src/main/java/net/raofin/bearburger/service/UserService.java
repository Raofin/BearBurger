package net.raofin.bearburger.service;

import net.raofin.bearburger.model.User;
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

    void makePayment(int spent);

    void deleteUser(String username);

    void deleteUserById(int id);

    void disableUser(int id);

    void enableUser(int id);

    void makeAdmin(int id);

    void removeAdmin(int id);

    List<User> searchUserByEmail(String email);
}
