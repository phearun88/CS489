/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class UserDTO {

    private Long userId;
    private String username;
    private String password;

}


