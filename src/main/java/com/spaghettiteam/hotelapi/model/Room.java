package com.spaghettiteam.hotelapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String roomNumber;
    private long pricePerDay;

    public Room() {
    }

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Room(String roomNumber, long pricePerDay) {
        this.roomNumber = roomNumber;
        this.pricePerDay = pricePerDay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(long pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
