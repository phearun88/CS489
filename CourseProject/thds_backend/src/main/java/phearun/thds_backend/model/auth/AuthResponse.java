package phearun.thds_backend.model.auth;

import lombok.Builder;
import lombok.Data;
import phearun.thds_backend.model.Role;

import java.util.List;

@Data
//@Builder
public class AuthResponse {
    private Long id;
    private String email;
    private String token;
    private List<Role> roles;
}
