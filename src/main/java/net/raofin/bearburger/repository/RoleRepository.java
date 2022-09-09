package net.raofin.bearburger.repository;

import net.raofin.bearburger.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>
{
    @Modifying
    @Query("DELETE FROM Role u WHERE u.userID = ?1 AND u.name = 'ADMIN'")
    void deleteByUserId(int id);
}
