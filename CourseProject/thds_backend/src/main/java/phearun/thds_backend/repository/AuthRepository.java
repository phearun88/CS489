/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import phearun.thds_backend.model.Issue;
import phearun.thds_backend.model.User;

import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    //@Modifying
    @Query(value = "INSERT INTO user_role (user_id, role_id) VALUES (:userId, :roleId)", nativeQuery = true)
    void insertUserRole(@Param("userId") long userId, @Param("roleId") long roleId);

}
