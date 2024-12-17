package com.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    private String hotelId;
    private String name;
    private String location;
    private String about;

    public Hotel() {
    }
    public Hotel(String hotelId, String name, String location, String about) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.about = about;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId='" + hotelId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", about='" + about + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel)o;
        return Objects.equals(hotelId, hotel.hotelId) && Objects.equals(name, hotel.name) && Objects.equals(location, hotel.location) && Objects.equals(about, hotel.about);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, name, location, about);
    }



}

