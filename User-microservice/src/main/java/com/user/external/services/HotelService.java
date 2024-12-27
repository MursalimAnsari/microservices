package com.user.external.services;

import com.user.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-MICROSERVICE")
public interface HotelService {
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotelUrl(@PathVariable("hotelId") String hotelId);
}
