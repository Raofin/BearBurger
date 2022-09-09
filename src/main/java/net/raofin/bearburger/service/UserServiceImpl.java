package net.raofin.bearburger.service;

import net.raofin.bearburger.repository.RolesRepository;
import net.raofin.bearburger.repository.UserRepository;
import net.raofin.bearburger.model.User;
import net.raofin.bearburger.model.UserRoles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RolesRepository rolesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElse(null);

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
        return userRepository.findAll();
    }

    @Override
    public void registerUser(User user) {


        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        rolesRepository.save(new UserRoles(user.getUserID()));
    }

    @Override
    public User fetchUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User fetchUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User fetchUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public void updateUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteUser(username);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void disableUser(int id) {

        User user = userRepository.getReferenceById(id);
        user.setEnabled(false);
        userRepository.save(user);
    }

    @Override
    public void enableUser(int id) {

        User user = userRepository.getReferenceById(id);
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Override
    public void makeAdmin(int id) {
        rolesRepository.save(new UserRoles(id, "ADMIN"));
    }

    @Override
    public void removeAdmin(int id) {
        rolesRepository.deleteByUserId(id);
    }

    @Override
    public List<User> searchUserByEmail(String email) {
        return userRepository.searchByEmail(email);
    }
}