/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(generator = "category_seq_generator")
    @SequenceGenerator(name = "category_seq_generator", initialValue = 1, sequenceName = "category_seq")
    private Long id;
    private String name;
    private Boolean active;
    private Long userId;

    public Category(String name){
        this.name = name;
    }


}


