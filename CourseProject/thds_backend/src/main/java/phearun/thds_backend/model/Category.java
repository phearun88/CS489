/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cateId;
    @Column(name = "cate_nm")
    private String cateNm;
    private String cateStatus;
    private String createdDate;
    private String updatedDate;
    private Long userId;


}


