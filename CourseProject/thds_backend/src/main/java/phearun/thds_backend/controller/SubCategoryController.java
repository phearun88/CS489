/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import phearun.thds_backend.dto.SubCategoryDTO;
import phearun.thds_backend.exception.ApiException;
import phearun.thds_backend.mapper.SubCategoryMapper;
import phearun.thds_backend.model.SubCategory;
import phearun.thds_backend.service.SubCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryController {

    @Autowired
    private  SubCategoryService subCategoryService;

    @PostMapping
    public ResponseEntity<SubCategory> create(@RequestBody SubCategoryDTO SubCategoryDTO){
        SubCategory SubCategory = SubCategoryMapper.INSTANCE.toEntity(SubCategoryDTO);
        SubCategory = subCategoryService.save(SubCategory);
        return ResponseEntity.ok(SubCategory);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) throws ApiException {
        System.out.println("ID========="+ id);
        return ResponseEntity.ok(subCategoryService.getById(id));
    }



    @PutMapping("{id}")
    public ResponseEntity<SubCategory> update(@PathVariable("id") int id, @RequestBody SubCategoryDTO SubCategoryDTO) throws ApiException {
        SubCategory brand =  SubCategoryMapper.INSTANCE.toEntity(SubCategoryDTO);
        return ResponseEntity.ok(subCategoryService.update(id, brand));
    }

    @GetMapping
    public ResponseEntity<?> list(){
        List<SubCategoryDTO> listCategories = subCategoryService.getSubCategories()
                .stream()
                .map(c -> SubCategoryMapper.INSTANCE.toDTO(c))
                .toList();
        return ResponseEntity.ok(listCategories);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getSubCategoryByCategoryId(@PathVariable("id") Long id){
        List<SubCategoryDTO> listSubCategoriesByCategoryId = subCategoryService.getSubCategoryByCategoryId(id)
                .stream()
                .map(c -> SubCategoryMapper.INSTANCE.toDTO(c))
                .toList();
        return ResponseEntity.ok(listSubCategoriesByCategoryId);
    }
//    @GetMapping("{id}")
//    public ResponseEntity<?> getById(@PathVariable("id") int id) throws ApiException {
//        System.out.println("ID========="+ id);
//        return ResponseEntity.ok(subCategoryService.getById(id));
//    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        subCategoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
