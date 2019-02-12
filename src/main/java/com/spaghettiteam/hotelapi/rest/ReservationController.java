package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.dto.ReservationDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/api/find_rooms")
    public List<Reservation> getAvailableRoomsBetweenDates(@RequestBody TwoDatesSearch twoDatesSearch) {
        return reservationService.findAvailableRoomsBetweenDates(twoDatesSearch);
    }

    @GetMapping("/api/reservation/{id}")
    public Reservation getReservationId(@PathVariable long id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/api/reservation/all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/api/reservation/room/{roomNumber}")
    public List<Reservation> getAllReservationsByRoomNumber(@PathVariable long roomNumber) {
        return reservationService.getAllByReservationsByRoomNumber(roomNumber);
    }

    @DeleteMapping("/api/reservation/{id}")
    public Reservation deleteReservationId(@PathVariable long id) {
        return reservationService.deleteReservationById(id);
    }

    @PostMapping("/api/reservation/{id}")
    public Reservation updateReservationId(@PathVariable long id, @RequestBody Reservation reservation) {
        return reservationService.updateReservationById(id, reservation);
    }

    @PostMapping("/api/reservation/add")
    public Reservation addReservation(@RequestBody ReservationDTO reservation) {
        return reservationService.addReservation(reservation);
    }

}
