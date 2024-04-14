///**
// * Author : PhearunPhin
// * Date : 4/4/2024
// */
//
//package phearun.thds_backend.controller;
//
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import phearun.thds_backend.dto.CategoryDTO;
//import phearun.thds_backend.dto.UserDTO;
//import phearun.thds_backend.mapper.CategoryMapper;
//import phearun.thds_backend.mapper.UserMapper;
//import phearun.thds_backend.model.User;
//import phearun.thds_backend.service.UserService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/users")
//@AllArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//
//    @PostMapping
//    public ResponseEntity<User> create(@RequestBody UserDTO userDTO){
//        User category = UserMapper.INSTANCE.toEntity(userDTO);
//        category = userService.save(category);
//        return ResponseEntity.ok(category);
//    }
//
//
//    @GetMapping
//    public ResponseEntity<?> list(){
//        List<UserDTO> listUsers = userService.getUsers()
//                .stream()
//                .map(c -> UserMapper.INSTANCE.toDTO(c))
//                .toList();
//        return ResponseEntity.ok(listUsers);
//    }
//
//}
