package phearun.thds_backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import phearun.thds_backend.dto.CategoryDTO;
import phearun.thds_backend.dto.SubCategoryDTO;
import phearun.thds_backend.model.Category;
import phearun.thds_backend.model.SubCategory;
import phearun.thds_backend.service.CategoryService;



@Mapper(componentModel = "spring", uses = {CategoryService.class})
public interface SubCategoryMapper {
    SubCategoryMapper INSTANCE = Mappers.getMapper(SubCategoryMapper.class);
    @Mapping(target = "category", source = "dto.cateId")
    SubCategory toSubCategory(SubCategoryDTO dto);

    @Mapping(target = "cateId", source = "category.id")
    SubCategoryDTO toDTO(SubCategory entity);

}

