/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import phearun.thds_backend.dto.CategoryDTO;
import phearun.thds_backend.dto.UserDTO;
import phearun.thds_backend.dto.request.UserAuthRequest;
import phearun.thds_backend.dto.respone.UserAuthResponse;
import phearun.thds_backend.mapper.UserMapper;
import phearun.thds_backend.model.User;
import phearun.thds_backend.service.UserService;
import phearun.thds_backend.service.util.JWTMgmtUtilityService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private JWTMgmtUtilityService jwtMgmtUtilityService;
    private AuthenticationManager authenticationManager;

    private final UserService userService;


    public UserController(JWTMgmtUtilityService jwtMgmtUtilityService,
                              AuthenticationManager authenticationManager,
                              UserService userService) {
        this.jwtMgmtUtilityService = jwtMgmtUtilityService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO userDTO){
        User category = UserMapper.INSTANCE.toEntity(userDTO);
        category = userService.save(category);
        return ResponseEntity.ok(category);
    }


    @GetMapping
    public ResponseEntity<?> list(){
        List<UserDTO> listUsers = userService.getUsers()
                .stream()
                .map(c -> UserMapper.INSTANCE.toDTO(c))
                .toList();
        return ResponseEntity.ok(listUsers);
    }


    @PostMapping(value = {"/login"})
    public ResponseEntity<UserAuthResponse> authenticateUser(@Valid @RequestBody UserAuthRequest userAuthRequest) throws Exception {
        UserAuthResponse userAuthResponse = null;
        try {
            var username = userAuthRequest.username();
            var password = userAuthRequest.password();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,
                            password)
            );
            var jwtToken = jwtMgmtUtilityService.generateToken(username);
            var user = userService.getUserByUsername(username);
            if(user != null) {
                userAuthResponse = new UserAuthResponse(jwtToken, user.getFirstName(), user.getLastName());
            }
        } catch (Exception ex) {
            System.out.println("UserAuthException is: " + ex);
            throw ex;
        }
        return ResponseEntity.ok(userAuthResponse);
    }

}
