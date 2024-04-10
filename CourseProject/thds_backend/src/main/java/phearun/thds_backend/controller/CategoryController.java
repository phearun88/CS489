/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phearun.thds_backend.dto.CategoryDTO;
import phearun.thds_backend.exception.ApiException;
import phearun.thds_backend.mapper.CategoryMapper;
import phearun.thds_backend.model.Category;
import phearun.thds_backend.service.CategoryService;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO categoryDTO){
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDTO);

        category.setUserId(25L);

        System.out.println("category + " +category);

        category = categoryService.save(category);
        return ResponseEntity.ok(category);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) throws ApiException {
        return ResponseEntity.ok(categoryService.getById(id));
    }

//    @GetMapping("/subcategory/{cate_id}")
//    public ResponseEntity<?> getByCategory(@PathVariable("cate_id") int id) throws ApiException {
//        System.out.println("ID========="+ id);
//        return ResponseEntity.ok(categoryService.getByCategory(id));
//    }

    @PutMapping("{id}")
    public ResponseEntity<Category> update(@PathVariable("id") int id, @RequestBody CategoryDTO categoryDTO) throws ApiException {
        Category brand =  CategoryMapper.INSTANCE.toEntity(categoryDTO);
        return ResponseEntity.ok(categoryService.update(id, brand));
    }

    @GetMapping
    public ResponseEntity<?> list(){
        List<CategoryDTO> listCategories = categoryService.getCategories()
                .stream()
                .map(c -> CategoryMapper.INSTANCE.toDTO(c))
                .toList();
        return ResponseEntity.ok(listCategories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
