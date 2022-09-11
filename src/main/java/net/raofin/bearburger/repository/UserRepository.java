package net.raofin.bearburger.repository;

import net.raofin.bearburger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);

    @Query("DELETE FROM User u WHERE u.username = ?1")
    void deleteUser(String username);

    @Query("SELECT u FROM User u WHERE u.email LIKE %?1%")
    List<User> searchByEmail(String email);
}
