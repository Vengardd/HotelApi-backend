package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.repository.ReservationRepository;
import com.spaghettiteam.hotelapi.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/api/find_rooms")
    private List<Reservation> getAvailableRoomsBetweenDates(TwoDatesSearch twoDatesSearch) {
        return reservationService.findAvailableRoomsBetweenDates(twoDatesSearch);
    }

    @GetMapping("/api/add")
    public Reservation addReservation() {
        return reservationRepository.save(new Reservation());
    }

    @GetMapping("/api/all")
    public List<Reservation> getAllReservation() {
        return (List<Reservation>) reservationRepository.findAll();
    }
}
