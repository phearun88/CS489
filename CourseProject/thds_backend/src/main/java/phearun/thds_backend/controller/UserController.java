/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;


import phearun.thds_backend.dto.CategoryDTO;
import phearun.thds_backend.dto.SubCategoryDTO;
import phearun.thds_backend.dto.UserDTO;

import phearun.thds_backend.exception.ApiException;
import phearun.thds_backend.mapper.CategoryMapper;
import phearun.thds_backend.mapper.SubCategoryMapper;
import phearun.thds_backend.mapper.UserMapper;
import phearun.thds_backend.model.Category;
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

        System.out.println("user9 +  +"+ user);

        if(user.getGender() == null || user.getGender()== ""){
            user.setGender("Other");
        }
        user.setStatus("1");
        user.setIsAccountNonExpired(true);
        user.setIsAccountNonLocked(true);
        user.setIsCredentialsNonExpired(true);
        user.setIsEnabled(true);

        User getUserId = userService.findByEmail(user.getEmail());

//        if (getUserId != null) {
//            // Insert the user role into the join table
//            userService.insertUserRole(getUserId.getId(), 1);
//        } else {
//            // Handle case where user retrieval failed
//            throw new RuntimeException("Failed to retrieve user after registration.");
//        }

        return userService.registerUser(user);

    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getUserProfile(@PathVariable("email") String email){

        System.out.println("getUserProfile" + email);
        User getUser = userService.findByEmail(email);

        return ResponseEntity.ok(getUser);
    }

    @PutMapping("{email}")
    public ResponseEntity<User> update(@PathVariable("email") String email, @RequestBody User user) throws ApiException {


        user.setIsAccountNonExpired(true);
        user.setIsAccountNonLocked(true);
        user.setIsCredentialsNonExpired(true);
        user.setIsEnabled(true);

        return ResponseEntity.ok(userService.update(email, user));
    }



}
