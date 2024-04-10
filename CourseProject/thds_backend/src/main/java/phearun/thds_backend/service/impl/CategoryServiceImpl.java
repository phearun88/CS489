/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import phearun.thds_backend.exception.ApiException;
import phearun.thds_backend.model.Category;
import phearun.thds_backend.model.SubCategory;
import phearun.thds_backend.model.User;
import phearun.thds_backend.repository.CategoryRepository;
import phearun.thds_backend.repository.UserRepository;
import phearun.thds_backend.service.CategoryService;
import phearun.thds_backend.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public Category getById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, String.format("category not found for id=%d", id)));
    }



//    @Override
//    public SubCategory getByCategory(Integer cate_id) {
//        return categoryRepository.findByCateId(cate_id);
//    }

    @Override
    public Category update(Integer id, Category category) {
        Category target = getById(id);

        BeanUtils.copyProperties(category, target, "cate_id");

        return categoryRepository.save(target);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
