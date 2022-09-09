package net.raofin.bearburger.service;

import net.raofin.bearburger.model.Food;

import java.util.List;

public interface FoodService
{
    List<Food> fetchAllFoods();

    void addFood(Food food);

    Food fetchFoodByID(int id);

    Food fetchFoodByTitle(String title);

    List<Food> fetchFoodByCategory(String category);

    void updateFood(Food food);

    void deleteFoodById(int id);

    List<Food> searchFoodByTitle(String title);
}