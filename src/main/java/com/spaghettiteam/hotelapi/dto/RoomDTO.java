package com.spaghettiteam.hotelapi.dto;

public class RoomDTO {

    private String roomNumber;

    public RoomDTO() {
    }

    public RoomDTO(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
