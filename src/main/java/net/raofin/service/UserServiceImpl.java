package net.raofin.service;

import net.raofin.dao.UserDao;
import net.raofin.model.User;
import net.raofin.model.UserRoles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.fetchUserByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("Username not found.");

        ArrayList<GrantedAuthority> authorities = new ArrayList<>();

        for (UserRoles userRoles : user.getUserRoles())
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userRoles.getRole()));

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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
        if (Objects.equals(user.getUsername(), "Raofin") || Objects.equals(user.getUsername(), "admin"))
            return;

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(String username) {
        if (Objects.equals(username, "Raofin") || Objects.equals(username, "admin"))
            return;

        userDao.deleteUser(username);
    }

    @Override
    public void deleteUserById(int id) {
        if (id == 1 || id == 12)
            return;

        userDao.deleteUserById(id);
    }

    @Override
    public void disableUser(int id) {
        if (id == 1 || id == 12)
            return;

        userDao.disableUser(id);
    }

    @Override
    public void enableUser(int id) {
        userDao.enableUser(id);
    }

    @Override
    public void makeAdmin(int id) {
        userDao.makeAdmin(id);
    }

    @Override
    public void removeAdmin(int id) {
        if (id == 1 || id == 12)
            return;

        userDao.removeAdmin(id);
    }

    @Override
    public List<User> searchUserByEmail(String email) {
        return userDao.searchUserByEmail(email);
    }
}