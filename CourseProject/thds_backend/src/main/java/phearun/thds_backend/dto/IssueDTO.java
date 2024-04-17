/**
 * Author : PhearunPhin
 * Date : 4/5/2024
 */

package phearun.thds_backend.dto;

import lombok.Data;
import phearun.thds_backend.model.SubCategory;

@Data
public class IssueDTO {

    private Long issId;
    private String issName;
    private Long cateId;

    private Long subCateId;
    //private SubCategory subCategory;
    private String issDesc;
    private String issStatus;
    private String issTp;
    private String issDraft;
    private String issDone;
    private Long issAssigneeTo;
    private Long userId;
    private String createdDate;
    private String updatedDate;

}
