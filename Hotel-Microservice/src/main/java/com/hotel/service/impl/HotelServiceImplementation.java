package com.hotel.service.impl;

import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.model.Hotel;
import com.hotel.repository.HotelRepository;
import com.hotel.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImplementation implements HotelService {

     private HotelRepository hotelRepository;

    public HotelServiceImplementation(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels;
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("hotel not found with "+ hotelId));
    }
}
