package net.raofin.dao;

import net.raofin.model.User;

import java.util.List;

public interface UserDao
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
