package net.raofin.service;

import net.raofin.dao.UserDao;
import net.raofin.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.fetchUserByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("Username not found.");

        System.out.println("Logged in!");
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();

        System.out.println(user);
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        System.out.println(authorities);
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> fetchAllUsers() {
        return userDao.fetchAllUsers();
    }

    @Override
    public void registerUser(User user) {
        userDao.registerUser(user);
    }

    @Override
    public User fetchUserById(int id) {
        return userDao.fetchUserById(id);
    }

    @Override
    public User fetchUserByUsername(String username) {
        return userDao.fetchUserByUsername(username);
    }

    @Override
    public User fetchUserByEmail(String email) {
        return userDao.fetchUserByEmail(email);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(String email) {
        userDao.deleteUser(email);
    }

    @Override
    public List<User> searchUserByEmail(String email) {
        return userDao.searchUserByEmail(email);
    }
}