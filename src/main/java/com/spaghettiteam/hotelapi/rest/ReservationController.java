package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.repository.ReservationRepository;
import com.spaghettiteam.hotelapi.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;


    //ToDo check why twoDatesSearch fields are null
    @PostMapping("/api/find_rooms")
    public List<Reservation> getAvailableRoomsBetweenDates(TwoDatesSearch twoDatesSearch) {
        return reservationService.findAvailableRoomsBetweenDates(twoDatesSearch);
    }

    @PostMapping("/api/test")
    public List<Reservation> test(@DateTimeFormat(iso=DateTimeFormat.ISO.DATE) @ModelAttribute LocalDate localDate) {
        return reservationService.test2(localDate);
    }

    @GetMapping("/api/add")
    public Reservation addReservation() {
        return reservationRepository.save(new Reservation());
    }

    @GetMapping("/api/all")
    public List<Reservation> getAllReservation() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @ModelAttribute
    LocalDate initLocalDate() {
        return LocalDate.now();
    }
}
