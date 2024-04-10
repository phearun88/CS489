/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.dto;

import lombok.Data;

@Data
public class SubCategoryDTO {

    private Long subCateId;
    private Long cateId;
    private String subNm;
    private String subStatus;
    private String createdDate;
    private String updatedDate;
    private Long userId;

}


