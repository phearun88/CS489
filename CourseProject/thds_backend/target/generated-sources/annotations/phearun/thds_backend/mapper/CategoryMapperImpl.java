package phearun.thds_backend.mapper;

import javax.annotation.processing.Generated;
import phearun.thds_backend.dto.CategoryDTO;
import phearun.thds_backend.model.Category;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-19T16:27:03-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toEntity(CategoryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( dto.getId() );
        category.setName( dto.getName() );
        category.setActive( dto.getActive() );
        category.setUserId( dto.getUserId() );

        return category;
    }

    @Override
    public CategoryDTO toDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );
        categoryDTO.setActive( category.getActive() );
        categoryDTO.setUserId( category.getUserId() );

        return categoryDTO;
    }
}
