/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.dto;

import lombok.Data;

@Data
public class CategoryDTO {

    private Long id;
    private String name;
    private Boolean active;
    private Long userId;

}


