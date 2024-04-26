/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import phearun.thds_backend.dto.UserDTO;
import phearun.thds_backend.model.User;
import phearun.thds_backend.repository.AuthRepository;
import phearun.thds_backend.service.UserService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AuthRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public User registerUser(User user) {

        try{
            System.out.println("user ======" + user);

            user.setPassword(passwordEncoder.encode(user.getPassword()));

            User saveUser = userRepository.save(user);

            User getUserId = userRepository.findByEmail(user.getEmail());

            if (getUserId != null) {
                userRepository.insertUserRole(getUserId.getId(), 2);
            } else {
                // Handle case where user retrieval failed
                throw new RuntimeException("Failed to retrieve user after registration.");
            }

            return saveUser;
        }catch (Exception ex) {
            // Log and handle the exception
            ex.printStackTrace();
            throw new RuntimeException("Error registering user: " + ex.getMessage());
        }

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User update(String email, User user) {
                User target = findByEmail(email);

        BeanUtils.copyProperties(user, target, "email");

        return userRepository.save(target);
    }


//    @Override
//    public UserDTO update(String email, UserDTO user) {
//
//        User target = findByEmail(email);
//
//        BeanUtils.copyProperties(user, target, "email");
//
//        return userRepository.save(target);
//    }


}
