/**
 * Author : PhearunPhin
 * Date : 4/18/2024
 */

package phearun.thds_backend.category;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import phearun.thds_backend.exception.ApiException;
import phearun.thds_backend.model.Category;
import phearun.thds_backend.repository.CategoryRepository;
import phearun.thds_backend.service.CategoryService;
import phearun.thds_backend.service.impl.CategoryServiceImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryServiceIntegrationTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testSaveCategory() {
        // given
        Category category = new Category();
        category.setName("PhoneAPP");

        // when
        Category savedCategory = categoryService.save(category);

        // then
        assertNotNull(savedCategory.getId());
        assertEquals("PhoneAPP", savedCategory.getName());

        // Check if the category is actually saved in the database
        Optional<Category> retrievedCategory = categoryRepository.findById(savedCategory.getId());
      //  assertTrue(retrievedCategory.isPresent());
        assertEquals("PhoneAPP", retrievedCategory.get().getName());
    }

    @Test
    public void getByIdSuccess() {
        // given
        // Load test data into the database

        // when
        Category categoryReturn = categoryService.getById(1L);

        // then
        assertNotNull(categoryReturn);
        assertEquals("PhoneAPP", categoryReturn.getName());
        assertEquals(1L, categoryReturn.getId());
    }

    @Test
    public void getByIdThrowException() {
        // given
        // Load test data into the database

        // when
        // Try to get a category that doesn't exist
        assertThatThrownBy(() -> categoryService.getById(52L))
                .isInstanceOf(ApiException.class)
                .hasMessageStartingWith("category not found for id=");
    }
}

