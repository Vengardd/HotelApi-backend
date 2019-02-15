package com.spaghettiteam.hotelapi.dto;

public class RoomDTO {

    private String roomNumber;
    private long pricePerDay;

    public RoomDTO() {
    }

    public RoomDTO(String roomNumber, long pricePerDay) {

        this.roomNumber = roomNumber;
        this.pricePerDay = pricePerDay;
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
