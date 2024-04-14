package phearun.thds_backend.service;


import phearun.thds_backend.model.Category;
import phearun.thds_backend.model.SubCategory;

import java.util.List;

public interface CategoryService {
    Category save(Category entity);

    Category getById(Long id);

    //SubCategory getByCategory(Integer cate_id);


    Category update(Long id, Category category) ;

    List<Category> getCategories();

    void delete(Long id);
}
