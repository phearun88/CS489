/**
 * Author : PhearunPhin
 * Date : 4/16/2024
 */

package phearun.thds_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueDetailDTO {

    private Long issId;
    private String issName;

}
