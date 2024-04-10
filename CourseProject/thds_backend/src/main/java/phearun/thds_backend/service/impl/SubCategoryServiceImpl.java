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
import phearun.thds_backend.model.SubCategory;

import phearun.thds_backend.repository.SubCategoryRepository;
import phearun.thds_backend.service.SubCategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;


    @Override
    public SubCategory save(SubCategory entity) {
        return subCategoryRepository.save(entity);
    }

    @Override
    public SubCategory getById(Integer id) {
        return subCategoryRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, String.format("SubCategory not found for id=%d", id)));
    }

    @Override
    public List<SubCategory> getSubCategoryByCategoryId(Long id) {
        System.out.println(subCategoryRepository.findSubCategoriesByCateId(id));
        return subCategoryRepository.findSubCategoriesByCateId(id);
    }


    @Override
    public SubCategory update(Integer id, SubCategory SubCategory) {
        SubCategory target = getById(id);

        BeanUtils.copyProperties(SubCategory, target, "subId");

        return subCategoryRepository.save(target);
    }

    @Override
    public List<SubCategory> getSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        subCategoryRepository.deleteById(id);
    }
}
