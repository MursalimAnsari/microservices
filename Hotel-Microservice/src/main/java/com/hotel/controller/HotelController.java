package com.hotel.controller;

import com.hotel.model.Hotel;
import com.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/create")
    public ResponseEntity<Hotel>  addNewHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.createHotel(hotel);
     return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel>  getHotelById(@PathVariable String hotelId){
        Hotel hotel = hotelService.getHotelById(hotelId);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>>  getAllHotels( ){
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

}
