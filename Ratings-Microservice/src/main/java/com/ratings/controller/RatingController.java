package com.ratings.controller;

import com.ratings.model.Rating;
import com.ratings.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;


    @PostMapping("/create")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
        Rating rating1 = ratingService.createRating(rating);
        return new ResponseEntity<>(rating1, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> ratings = ratingService.getAllRatings();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId){
        List<Rating> ratings = ratingService.getRatingsByUserId(userId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelId){
        List<Rating> ratings = ratingService.getRatingsByHotelId(hotelId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

}
