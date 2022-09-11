package net.raofin.bearburger.dao;

import net.raofin.bearburger.model.Food;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
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
        Query<Food> foodQuery = session.createQuery("FROM Food WHERE Food_ID = " + id, Food.class);

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
    public void deleteFoodById(int id) {

        Food food = fetchFoodByID(id);
        sessionFactory.getCurrentSession().delete(food);
    }

    @Override
    public List<Food> searchFoodByTitle(String title) {

        Session session = sessionFactory.getCurrentSession();
        Query<Food> foodQuery = session.createQuery("FROM Food WHERE Title like '%" + title + "%'", Food.class);

        return foodQuery.getResultList();
    }
}
