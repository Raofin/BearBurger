package net.raofin.bearburger.repository;

import net.raofin.bearburger.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer>
{
    @Query("SELECT c FROM Comment c WHERE c.foodID = ?1")
    List<Comment> findByFoodId(int foodID);

    @Query("SELECT c FROM Comment c WHERE c.foodID = ?1 AND c.parentID = ?2")
    List<Comment> findByParentId(int foodID, int parentID);
}
