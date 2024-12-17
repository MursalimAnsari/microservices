package com.hotel.service;


import com.hotel.model.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel  createHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotelById(String hotelId);

}
