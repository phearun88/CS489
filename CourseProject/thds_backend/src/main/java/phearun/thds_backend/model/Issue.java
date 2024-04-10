/**
 * Author : PhearunPhin
 * Date : 4/5/2024
 */

package phearun.thds_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
