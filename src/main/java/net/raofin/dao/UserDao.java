package net.raofin.dao;

import net.raofin.model.User;

import java.util.List;

public interface UserDao
{
    List<User> fetchAllUsers();

    void registerUser(User user);

    User fetchUserById(int id);

    User fetchUserByUsername(String username);

    User fetchUserByEmail(String email);

    void updateUser(User user);

    void deleteUser(String username);

    List<User> searchUserByEmail(String email);
}
