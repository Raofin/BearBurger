package net.raofin.service;

import net.raofin.dao.FoodDao;
import net.raofin.model.Food;

import java.util.List;

public class FoodServiceImpl implements FoodService
{
    private final FoodDao foodDao;

    public FoodServiceImpl(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Override
    public List<Food> fetchAllFoods() {
        return foodDao.fetchAllFoods();
    }

    @Override
    public void addFood(Food food) {
        foodDao.addFood(food);
    }

    @Override
    public Food fetchFoodByID(int id) {
        return foodDao.fetchFoodByID(id);
    }

    @Override
    public Food fetchFoodByTitle(String title) {
        return foodDao.fetchFoodByTitle(title);
    }

    @Override
    public List<Food> fetchFoodByCategory(String category) {
        return foodDao.fetchFoodByCategory(category);
    }

    @Override
    public void updateFood(Food food) {
        foodDao.updateFood(food);
    }

    @Override
    public void deleteFoodByTitle(String title) {
        foodDao.deleteFoodByTitle(title);
    }

    @Override
    public List<Food> searchFoodByTitle(String title) {
        return foodDao.searchFoodByTitle(title);
    }
}
