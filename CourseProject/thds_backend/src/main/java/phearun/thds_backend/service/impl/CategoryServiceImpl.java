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
import phearun.thds_backend.repository.CategoryRepository;
import phearun.thds_backend.service.CategoryService;


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
    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, String.format("category not found for id=%d", id)));
    }



//    @Override
//    public SubCategory getByCategory(Integer cate_id) {
//        return categoryRepository.findByCateId(cate_id);
//    }

    @Override
    public Category update(Long id, Category category) {
        Category target = getById(id);

        BeanUtils.copyProperties(category, target, "id");

        return categoryRepository.save(target);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
