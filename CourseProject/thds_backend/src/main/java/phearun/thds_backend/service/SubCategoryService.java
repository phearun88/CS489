package phearun.thds_backend.service;


import org.springframework.stereotype.Service;
import phearun.thds_backend.model.SubCategory;

import java.util.List;

public interface SubCategoryService {
    SubCategory save(SubCategory entity);

    SubCategory getById(Long id);
//
    List<SubCategory> getSubCategoryByCategoryId(Long id);
//
//
//    SubCategory update(Long id, SubCategory subCategory) ;
//
    List<SubCategory> getSubCategories();
//
//    void delete(Integer id);
}
