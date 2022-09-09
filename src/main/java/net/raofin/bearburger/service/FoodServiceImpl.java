package net.raofin.bearburger.service;

import net.raofin.bearburger.repository.FoodRepository;
import net.raofin.bearburger.model.Food;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FoodServiceImpl implements FoodService
{
    private final FoodRepository foodDao;

    public FoodServiceImpl(FoodRepository foodDao) {
        this.foodDao = foodDao;
    }

    @Override
    public List<Food> findAll() {
        return foodDao.findAll();
    }

    @Override
    public void save(Food food) {
        foodDao.save(food);
    }

    @Override
    public Food findById(int id) {
        return foodDao.findById(id).orElse(null);
    }

    @Override
    public Food findByTitle(String title) {
        return foodDao.findByTitle(title).orElse(null);
    }

    @Override
    public List<Food> findByCategory(String category) {
        return foodDao.findByCategory(category);
    }

    @Override
    public void deleteById(int id) {
        foodDao.deleteById(id);
    }

    @Override
    public List<Food> searchByTitle(String title) {
        return foodDao.searchByTitle(title);
    }
}
