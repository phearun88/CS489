package phearun.thds_backend.service;


import org.springframework.stereotype.Service;
import phearun.thds_backend.model.SubCategory;

import java.util.List;

public interface SubCategoryService {
    SubCategory save(SubCategory entity);

    SubCategory getById(Integer id);

    List<SubCategory> getSubCategoryByCategoryId(Long id);


    SubCategory update(Integer id, SubCategory subCategory) ;

    List<SubCategory> getSubCategories();

    void delete(Integer id);
}
