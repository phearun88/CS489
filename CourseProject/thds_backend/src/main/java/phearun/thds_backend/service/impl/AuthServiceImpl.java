package phearun.thds_backend.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import phearun.thds_backend.model.auth.AuthRequest;
import phearun.thds_backend.model.auth.AuthResponse;
import phearun.thds_backend.service.AuthService;
import phearun.thds_backend.util.JwtTokenUtil;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    @Override
    public ResponseEntity<?> login(AuthRequest authRequest) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );

            UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();

            AuthResponse authResponse = new AuthResponse();
            authResponse.setEmail(userDetails.getUser().getEmail());
            authResponse.setId(userDetails.getUser().getId());
            authResponse.setRoles(userDetails.getUser().getRoles());
            String token = jwtTokenUtil.generateToken(userDetails.getUser());
            authResponse.setToken(token);

            return ResponseEntity.ok(authResponse);
        }catch (BadCredentialsException exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
