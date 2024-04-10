/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phearun.thds_backend.dto.UserDTO;
import phearun.thds_backend.mapper.UserMapper;
import phearun.thds_backend.model.User;
import phearun.thds_backend.service.UserService;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO userDTO){
        User category = UserMapper.INSTANCE.toEntity(userDTO);
        category = userService.save(category);
        return ResponseEntity.ok(category);
    }

}
