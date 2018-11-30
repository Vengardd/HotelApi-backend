package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WelcomeController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/api")
    public String welcome() {
        return "Hello world!";
    }

    @GetMapping("/api/reserv")
    public Reservation getReservation() {
        return reservationRepository.findById(1L).orElse(new Reservation());
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