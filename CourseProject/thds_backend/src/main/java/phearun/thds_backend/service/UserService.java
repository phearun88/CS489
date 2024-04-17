package phearun.thds_backend.service;


import phearun.thds_backend.model.Category;
import phearun.thds_backend.model.User;

import java.util.List;

public interface UserService {
    User save(User entity);

    List<User> getUsers();
    User getUserByUsername(String username);
}
