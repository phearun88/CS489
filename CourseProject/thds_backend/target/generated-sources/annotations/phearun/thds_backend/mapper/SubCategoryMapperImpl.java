package phearun.thds_backend.mapper;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phearun.thds_backend.dto.SubCategoryDTO;
import phearun.thds_backend.model.Category;
import phearun.thds_backend.model.SubCategory;
import phearun.thds_backend.service.CategoryService;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-19T16:27:03-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class SubCategoryMapperImpl implements SubCategoryMapper {

    @Autowired
    private CategoryService categoryService;

    @Override
    public SubCategory toSubCategory(SubCategoryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SubCategory subCategory = new SubCategory();

        subCategory.setCategory( categoryService.getById( dto.getCateId() ) );
        subCategory.setId( dto.getId() );
        subCategory.setName( dto.getName() );
        subCategory.setActive( dto.getActive() );
        subCategory.setUserId( dto.getUserId() );

        return subCategory;
    }

    @Override
    public SubCategoryDTO toDTO(SubCategory entity) {
        if ( entity == null ) {
            return null;
        }

        SubCategoryDTO subCategoryDTO = new SubCategoryDTO();

        subCategoryDTO.setCateId( entityCategoryId( entity ) );
        subCategoryDTO.setId( entity.getId() );
        subCategoryDTO.setName( entity.getName() );
        subCategoryDTO.setActive( entity.getActive() );
        subCategoryDTO.setUserId( entity.getUserId() );

        return subCategoryDTO;
    }

    private Long entityCategoryId(SubCategory subCategory) {
        if ( subCategory == null ) {
            return null;
        }
        Category category = subCategory.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
