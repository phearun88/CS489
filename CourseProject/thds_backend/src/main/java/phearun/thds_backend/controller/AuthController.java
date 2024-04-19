package phearun.thds_backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phearun.thds_backend.model.auth.AuthRequest;
import phearun.thds_backend.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){

        return authService.login(authRequest);

    }


//    @PostMapping(path = "/login")
//    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){
//        var user =  authService.login(authRequest);
//        return ResponseEntity.ok(user);
//    }
}
