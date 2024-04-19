/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "subcategory")
public class SubCategory {

    @Id
    @GeneratedValue(generator = "subcategory_seq_generator")
    @SequenceGenerator(name = "subcategory_seq_generator", initialValue = 1, sequenceName = "subcategory_seq")
    private Long id;

    @Column(name = "subcate_name")
    private String name;
    private Boolean active;
    private Long userId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cate_id")
    private Category category;

}


