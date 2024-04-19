/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.dto;

import jakarta.persistence.*;
import lombok.Data;
import phearun.thds_backend.model.Role;
import phearun.thds_backend.model.User;
import phearun.thds_backend.model.auth.AuthResponse;

import java.util.List;
import java.util.Set;

@Data
public class UserDTO {

//    private Long userId;
//    private String lastName;
//    private String firstName;
//    private String username;
//    private String password;
//    private String department;
//    private String position;
//    private String dob;
//    private String gender;
//    private String type;
//    private String status;


    private Long id;
    private String email;
    private String status;
    private List<Role> roles;




}


