package com.user.service.impl;

import com.user.exceptions.ResourceNotFoundException;
import com.user.external.services.HotelService;
import com.user.model.Hotel;
import com.user.model.Rating;
import com.user.model.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;
   @Autowired
   private RestTemplate restTemplate;
   @Autowired
   private HotelService hotelService;
   private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);



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
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with " +userId));
        Rating[] usersListWithRatings = restTemplate.getForObject("http://RATINGS-MICROSERVICE/ratings/users/"+user.getUserId(), Rating[].class);

        logger.info("{}", usersListWithRatings);
        List<Rating>  ratingList=
                Stream.of(usersListWithRatings)
                .map(rating -> {
                  Hotel hotel = hotelService.getHotelUrl(rating.getHotelId());
                    rating.setHotel(hotel);
                    return rating;
                }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}
