/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;


import phearun.thds_backend.dto.UserDTO;

import phearun.thds_backend.mapper.UserMapper;
import phearun.thds_backend.model.User;
import phearun.thds_backend.service.UserService;


import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping(path = "/register")
    public User register(@RequestBody User user){

        user.setStatus("1");
        user.setIsAccountNonExpired(true);
        user.setIsAccountNonLocked(true);
        user.setIsCredentialsNonExpired(true);
        user.setIsEnabled(true);

        return userService.registerUser(user);

    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }





}
