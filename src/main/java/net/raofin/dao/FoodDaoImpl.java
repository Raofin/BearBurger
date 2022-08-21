package net.raofin.dao;

import net.raofin.model.Food;
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
public class FoodDaoImpl implements FoodDao
{
    private final SessionFactory sessionFactory;

    public FoodDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Food> fetchAllFoods() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Food> foodQuery = session.createQuery("FROM Food", Food.class);
        List<Food> foods = foodQuery.getResultList();
        return foods == null ? new ArrayList<Food>() : foods;
    }

    @Override
    public void addFood(Food food) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(food);
    }

    @Override
    public Food fetchFoodByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Food> foodQuery = session.createQuery("FROM Food WHERE FoodID = " + id, Food.class);
        return foodQuery.getSingleResult();
    }

    @Override
    public Food fetchFoodByTitle(String title) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Food> foodQuery = session.createQuery("FROM Food WHERE Title = :title", Food.class);
        foodQuery.setParameter("title", title);
        return foodQuery.getSingleResult();
    }

    @Override
    public List<Food> fetchFoodByCategory(String category) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Food> foodQuery = session.createQuery("FROM Food WHERE Category = :category", Food.class);
        foodQuery.setParameter("category", category);
        return foodQuery.getResultList();
    }

    @Override
    public void updateFood(Food food) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(food);
    }

    @Override
    public void deleteFoodByTitle(String title) {
        Food food = fetchFoodByTitle(title);
        sessionFactory.getCurrentSession().delete(food);
    }

    @Override
    public List<Food> searchFoodByTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        Query<Food> foodQuery = session.createQuery("FROM Food WHERE Title LIKE '%:title%'", Food.class);
        foodQuery.setParameter("title", title);
        return foodQuery.getResultList();
    }
}
