/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SubCategoryDTO {

    private Long id;
    private String name;
    private Boolean active;
    private Long userId;
    private Long cateId;

}


