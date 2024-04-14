/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String lastName;
    private String firstName;
    private String username;
    private String password;
    private String department;
    private String position;
    private String dob;
    private String gender;
    private String type;
    private String status;


//    private Boolean isAccountNonExpired;
//    private Boolean isAccountNonLocked;
//    private Boolean isCredentialsNonExpired;
//    private Boolean isEnabled;

}


