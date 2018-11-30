package com.spaghettiteam.hotelapi.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation() {
    }

    public Reservation(User user, Room room, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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


    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", room=" + room +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
