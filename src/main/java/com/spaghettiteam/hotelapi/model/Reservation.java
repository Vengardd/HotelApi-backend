package com.spaghettiteam.hotelapi.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
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

    public static final class ReservationBuilder {
        private long id;
        private User user;
        private Room room;
        private LocalDate startDate;
        private LocalDate endDate;

        private ReservationBuilder() {
        }

        public static ReservationBuilder aReservation() {
            return new ReservationBuilder();
        }

        public ReservationBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public ReservationBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public ReservationBuilder withRoom(Room room) {
            this.room = room;
            return this;
        }

        public ReservationBuilder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public ReservationBuilder withEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Reservation build() {
            Reservation reservation = new Reservation();
            reservation.setId(id);
            reservation.setUser(user);
            reservation.setRoom(room);
            reservation.setStartDate(startDate);
            reservation.setEndDate(endDate);
            return reservation;
        }
    }
}
