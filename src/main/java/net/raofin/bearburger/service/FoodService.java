package net.raofin.bearburger.service;

import net.raofin.bearburger.model.Food;

import java.util.List;

public interface FoodService
{
    List<Food> findAll();

    void save(Food food);

    Food findById(int id);

    Food findByTitle(String title);

    List<Food> findByCategory(String category);

    void deleteById(int id);

    List<Food> searchByTitle(String title);
}
