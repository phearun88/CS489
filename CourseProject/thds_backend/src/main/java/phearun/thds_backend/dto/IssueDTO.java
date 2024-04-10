/**
 * Author : PhearunPhin
 * Date : 4/5/2024
 */

package phearun.thds_backend.dto;

import lombok.Data;

@Data
public class IssueDTO {

    private Long issId;
    private String issName;
    private Long cateId;
    private Long subCateId;
    private String issDesc;
    private String issStatus;
    private String issTp;
    private String issDraft;
    private Long issAssigneeTo;
    private Long userId;
    private String createdDate;
    private String updatedDate;


}
