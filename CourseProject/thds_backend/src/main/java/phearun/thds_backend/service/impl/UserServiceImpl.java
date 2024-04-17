/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phearun.thds_backend.model.User;
import phearun.thds_backend.repository.UserRepository;
import phearun.thds_backend.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElse(null);

    }
}
