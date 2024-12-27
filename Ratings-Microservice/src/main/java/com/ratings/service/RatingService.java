package com.ratings.service;


import com.ratings.model.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    // get rating by user-id
    List<Rating> getRatingsByUserId(String userId);

    // get rating by hotel-id
    List<Rating> getRatingsByHotelId(String hotelId);

    // get all ratings
    List<Rating> getAllRatings();

}
