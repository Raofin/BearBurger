package net.raofin.bearburger.service;

import net.raofin.bearburger.model.Role;
import net.raofin.bearburger.model.User;
import net.raofin.bearburger.repository.RoleRepository;
import net.raofin.bearburger.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElse(null);

        if (user == null)
            throw new UsernameNotFoundException("Username not found.");

        ArrayList<GrantedAuthority> authorities = new ArrayList<>();

        for (Role roles : user.getRoles())
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roles.getName()));

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
        roleRepository.save(new Role(user.getUserID()));
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
    @Transactional
    public void makePayment(int spent) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findByUsername(auth.getName())
                .orElseThrow(() -> new IllegalStateException("User doesn't exist!"));

        user.setSpent(user.getSpent() + spent);
    }

    @Override
    public void deleteUser(String username) {

        userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("User doesn't exist!"));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (Objects.equals(username, auth.getName()))
            return;

        userRepository.deleteUser(username);
    }

    @Override
    public void deleteUserById(int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User doesn't exist!"));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (Objects.equals(user.getUsername(), auth.getName()))
            return;

        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void disableUser(int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User doesn't exist!"));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (Objects.equals(user.getUsername(), auth.getName()))
            return;

        user.setEnabled(false);
    }

    @Override
    @Transactional
    public void enableUser(int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User doesn't exist!"));

        user.setEnabled(true);
    }

    @Override
    public void makeAdmin(int id) {
        roleRepository.save(new Role(id, "ADMIN"));
    }

    @Override
    public void removeAdmin(int id) {
        roleRepository.deleteByUserId(id);
    }

    @Override
    public List<User> searchUserByEmail(String email) {
        return userRepository.searchByEmail(email);
    }
}