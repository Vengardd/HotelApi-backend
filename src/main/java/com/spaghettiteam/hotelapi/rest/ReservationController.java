package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.dto.ReservationDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/api/find_rooms")
    public List<Reservation> getAvailableRoomsBetweenDates(@RequestBody TwoDatesSearch twoDatesSearch) {
        return reservationService.findAvailableRoomsBetweenDates(twoDatesSearch);
    }

    @PostMapping("/api/reservation/add")
    public Reservation addReservation(@RequestBody ReservationDTO reservation) {
        return reservationService.addReservation(reservation);
    }

}
