package phearun.thds_backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import phearun.thds_backend.dto.CategoryDTO;
import phearun.thds_backend.model.Category;


@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category toEntity(CategoryDTO dto);
    CategoryDTO toDTO(Category category);

}



