/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.dto;

import lombok.Data;

@Data
public class CategoryDTO {

    private Long cateId;
    private String cate_nm;
    private String cate_status;
    private String created_date;
    private String updated_date;
    private Long user_id;

}


