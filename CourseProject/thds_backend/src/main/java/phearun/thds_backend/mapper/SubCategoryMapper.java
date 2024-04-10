package phearun.thds_backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import phearun.thds_backend.dto.CategoryDTO;
import phearun.thds_backend.dto.SubCategoryDTO;
import phearun.thds_backend.model.Category;
import phearun.thds_backend.model.SubCategory;


@Mapper
public interface SubCategoryMapper {

    SubCategoryMapper INSTANCE = Mappers.getMapper(SubCategoryMapper.class);
    SubCategory toEntity(SubCategoryDTO dto);
    SubCategoryDTO toDTO(SubCategory category);

}
