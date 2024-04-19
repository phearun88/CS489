package phearun.thds_backend.model.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
