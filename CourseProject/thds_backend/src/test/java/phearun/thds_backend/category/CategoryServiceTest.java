/**
 * Author : PhearunPhin
 * Date : 4/18/2024
 */

package phearun.thds_backend.category;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import phearun.thds_backend.exception.ApiException;
import phearun.thds_backend.model.Category;
import phearun.thds_backend.repository.CategoryRepository;
import phearun.thds_backend.service.CategoryService;
import phearun.thds_backend.service.impl.CategoryServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    private CategoryService categoryService;


    @Captor
    private ArgumentCaptor<Category> categoryArgumentCaptor;

    private Category category;

    @BeforeEach
    public void setup() {
        categoryService = new CategoryServiceImpl(categoryRepository);
        category = new Category(1l,"PhoneAPP", true, 1l);
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
    }

    @Test
    public void testSaveCategory() {

        //given
        Category category = new Category();
        category.setName("PhoneAPP");

        Category categoryReturn = categoryService.save(category);

        //then
        verify(categoryRepository, times(1)).save(category);

    }

    @Test
    public void getByIdSuccess() {
        //given
        //when

        //then
        Category categoryReturn = categoryService.getById(1l);
        assertNotNull(categoryReturn);
        assertEquals("PhoneAPP", categoryReturn.getName());
        assertEquals(1l, categoryReturn.getId());
    }

    @Test
    public void getByIdThrowException() {

        //given

        //when
        when(categoryRepository.findById(523l)).thenReturn(Optional.empty());

        //then

        assertThatThrownBy(() -> categoryService.getById(52l))
                .isInstanceOf(ApiException.class)
                .hasMessageStartingWith("category not found for id=");

    }

//    @Test
//    public void testUpdateBrand() {
//        //given
//        List<Category> brands = List.of(
//                new Category(3l,"PhoneAPP", true, 2l),
//                new Category(4l,"PhoneAPP", true, 2l)
//        );
//        //when
//        when(categoryRepository.findByActiveTrue()).thenReturn(brands);
//        List<Category> categoryReturn = categoryService.getCategories();
//
//        //then
//        assertEquals(2, categoryReturn.size());
//        assertEquals("Apple", categoryReturn.get(0).getName());
//        assertEquals("Samsung", categoryReturn.get(1).getName());
//    }

//    @Test
//    public void testListBrand() {
//        //given
//        List<Category> categories = List.of(
//                new Category(1l,"PhoneAPP", true, 1l),
//                new Category(2l,"BankAPP", true, 25l)
//        );
//        //when
//        when(categoryRepository.findByActiveTrue()).thenReturn(brands);
//        List<Category> brandsReturn = brandService.getBrands();
//
//        //then
//        assertEquals(2, brandsReturn.size());
//        assertEquals("Apple", brandsReturn.get(0).getName());
//        assertEquals("Samsung", brandsReturn.get(1).getName());
//    }

}
