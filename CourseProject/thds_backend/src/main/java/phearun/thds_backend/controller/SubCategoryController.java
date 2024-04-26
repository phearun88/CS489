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

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryController {


    private final SubCategoryService subCategoryService;

    @Autowired
    private SubCategoryMapper subCategoryMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SubCategoryDTO dto) throws ApiException{
//        SubCategory SubCategory = SubCategoryMapper.INSTANCE.toEntity(SubCategoryDTO);
//
//        SubCategory.setUserId(25L);
//        SubCategory = subCategoryService.save(SubCategory);
//        return ResponseEntity.ok(SubCategory);

        SubCategory model = subCategoryMapper.toSubCategory(dto);
        model.setUserId(25L);
        model = subCategoryService.save(model);
        SubCategoryDTO subCategoryDTO = SubCategoryMapper.INSTANCE.toDTO(model);
        return ResponseEntity.ok(subCategoryDTO);



    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) throws ApiException {
        System.out.println("ID========="+ id);
        return ResponseEntity.ok(subCategoryService.getById(id));
    }
//
//
//
//    @PutMapping("{id}")
//    public ResponseEntity<SubCategory> update(@PathVariable("id") Long id, @RequestBody SubCategoryDTO SubCategoryDTO) throws ApiException {
//        SubCategory brand =  SubCategoryMapper.INSTANCE.toEntity(SubCategoryDTO);
//        return ResponseEntity.ok(subCategoryService.update(id, brand));
//    }
//
    @GetMapping
    public ResponseEntity<?> list(){
        List<SubCategoryDTO> listCategories = subCategoryService.getSubCategories()
                .stream()
                .map(c -> SubCategoryMapper.INSTANCE.toDTO(c))
                .toList();
        return ResponseEntity.ok(listCategories);
    }
//
    @GetMapping("/category/{id}")
    public ResponseEntity<?> getSubCategoryByCategoryId(@PathVariable("id") Long id){

        //id = 53l;
        System.out.println("==============="+ id);
        List<SubCategoryDTO> listSubCategoriesByCategoryId = subCategoryService.getSubCategoryByCategoryId(id)
                .stream()
                .map(c -> SubCategoryMapper.INSTANCE.toDTO(c))
                .toList();
        return ResponseEntity.ok(listSubCategoriesByCategoryId);
    }
//
//
//
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        subCategoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
