package phearun.thds_backend.service;

import phearun.thds_backend.model.User;


import java.util.List;



public interface UserService  {

    User registerUser(User user);
    List<User> getAllUsers();
    User findByEmail(String email);



}

