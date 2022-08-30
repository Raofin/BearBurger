package net.raofin.dao;

import net.raofin.model.User;
import net.raofin.model.UserRoles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao
{
    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> fetchAllUsers() {

        Session session = this.sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("FROM User", User.class);
        List<User> users = userQuery.getResultList();
        return users == null ? new ArrayList<User>() : users;
    }

    @Override
    public void registerUser(User user) {

        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
        session.save(new UserRoles(user.getUserID()));
    }

    @Override
    public User fetchUserById(int id) {

        Session session = this.sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("FROM User WHERE UserID = " + id, User.class);
        return userQuery.getSingleResult();
    }

    @Override
    public User fetchUserByUsername(String username) {

        Session session = this.sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("FROM User WHERE Username = :username", User.class);
        userQuery.setParameter("username", username);

        try {
            if (userQuery.getSingleResult().isEnabled()) {
                return userQuery.getSingleResult();
            }
            else return null;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User fetchUserByEmail(String email) {

        Session session = this.sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("FROM User WHERE Email = :email", User.class);
        userQuery.setParameter("email", email);
        return userQuery.getSingleResult();
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void deleteUser(String username) {

        Session session = this.sessionFactory.getCurrentSession();
        User user = fetchUserByUsername(username);
        session.delete(user);
    }

    @Override
    public void deleteUserById(int id) {

        Session session = this.sessionFactory.getCurrentSession();
        User user = fetchUserById(id);
        session.delete(user);
    }

    @Override
    public void disableUser(int id) {

        Session session = this.sessionFactory.getCurrentSession();
        User user = fetchUserById(id);
        user.setEnabled(false);
        session.update(user);
    }

    @Override
    public void enableUser(int id) {

        Session session = this.sessionFactory.getCurrentSession();
        User user = fetchUserById(id);
        user.setEnabled(true);
        session.update(user);
    }

    @Override
    public void makeAdmin(int id) {

        Session session = this.sessionFactory.getCurrentSession();
        UserRoles newRole = new UserRoles(id, "ADMIN");
        session.save(newRole);
    }

    @Override
    public void removeAdmin(int id) {

        Session session = this.sessionFactory.getCurrentSession();
        Query<UserRoles> userRolesQuery = session.createQuery("FROM UserRoles WHERE Role = 'ADMIN' AND UserID = " + id, UserRoles.class);
        List<UserRoles> userRoles = userRolesQuery.getResultList();
        for (UserRoles role : userRoles)
            session.delete(role);
    }

    @Override
    public List<User> searchUserByEmail(String email) {

        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("FROM User WHERE Email LIKE '%:email%'", User.class);
        userQuery.setParameter("email", email);
        return userQuery.getResultList();
    }
}
