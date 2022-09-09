package net.raofin.bearburger.repository;

import net.raofin.bearburger.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<UserRoles, Integer>
{
    @Query("DELETE FROM UserRoles u WHERE u.userID = ?1")
    void deleteByUserId(int id);
}
