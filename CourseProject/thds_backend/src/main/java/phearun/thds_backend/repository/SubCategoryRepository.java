/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phearun.thds_backend.model.Category;
import phearun.thds_backend.model.SubCategory;

import java.util.List;


@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

        List<SubCategory> findSubCategoriesByCateId(Long cateId);
}
