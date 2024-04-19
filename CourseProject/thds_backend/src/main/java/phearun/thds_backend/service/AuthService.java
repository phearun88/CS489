package phearun.thds_backend.service;


import org.springframework.http.ResponseEntity;
import phearun.thds_backend.model.auth.AuthRequest;

public interface AuthService {
    ResponseEntity<?> login(AuthRequest authRequest);

}
