/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subcategory")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subCateId;
    private Long cateId;
    private String subNm;
    private String subStatus;
    private String createdDate;
    private String updatedDate;
    private Long userId;
}


