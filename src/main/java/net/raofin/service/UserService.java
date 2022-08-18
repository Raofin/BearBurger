package net.raofin.service;

import net.raofin.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService
{
    public List<User> fetchAllUsers();

    public void registerUser(User user);

    public User fetchUserById(int id);

    public User fetchUserByUsername(String username);

    public User fetchUserByEmail(String email);

    public void updateUser(User user);

    public void deleteUser(String email);

    public List<User> searchUserByEmail(String email);
}
