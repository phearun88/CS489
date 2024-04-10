/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phearun.thds_backend.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {

}
