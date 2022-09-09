package net.raofin.bearburger.repository;

import net.raofin.bearburger.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer>
{
    @Query("SELECT f FROM Food f WHERE f.title = ?1")
    Optional<Food> findByTitle(String title);

    @Query("SELECT f FROM Food f WHERE f.category = ?1")
    List<Food> findByCategory(String category);

    @Query("SELECT f FROM Food f WHERE f.title LIKE %?1%")
    List<Food> searchByTitle(String title);
}
