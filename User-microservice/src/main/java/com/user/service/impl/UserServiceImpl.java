package com.user.service.impl;

import com.user.exceptions.ResourceNotFoundException;
import com.user.model.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   UserRepository userRepository;

    @Override
    public User save(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(String userId) {
          userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with " +userId));
    }
}
