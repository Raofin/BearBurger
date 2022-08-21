package net.raofin.dao;

import net.raofin.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class UserDaoImpl implements UserDao
{
    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> fetchAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("from User", User.class);
        List<User> users = userQuery.getResultList();
        return users == null ? new ArrayList<User>() : users;

//        Session session = this.sessionFactory.getCurrentSession();
//        Query<User> userQuery = session.createQuery("FROM User", User.class);
//        List<User> users = userQuery.getResultList();
//        return users == null ? new ArrayList<User>() : users;
    }

    @Override
    public void registerUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
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
        return userQuery.getSingleResult();
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
    public void deleteUser(String email) {
        User user = fetchUserByEmail(email);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public List<User> searchUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("FROM User WHERE Email LIKE '%:email%'", User.class);
        userQuery.setParameter("email", email);
        return userQuery.getResultList();
    }
}
