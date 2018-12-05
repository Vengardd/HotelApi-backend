package com.spaghettiteam.hotelapi.dto;

import java.time.LocalDate;

public class ReservationDTO {

    private long userId;
    private long roomId;
    private LocalDate startDate;
    private LocalDate endDate;

    public ReservationDTO() {
    }

    public ReservationDTO(long userId, long roomId, LocalDate startDate, LocalDate endDate) {
        this.userId = userId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
