package com.user.service;

import com.user.model.User;

import java.util.List;

public interface UserService {

     User save(User user);
     List<User> getAllUsers();
     void deleteUserById(String userId);
     User getUserById(String userId);


}
