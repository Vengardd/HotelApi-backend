package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.dto.ReservationDTO;
import com.spaghettiteam.hotelapi.dto.RoomDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesAndTwoPriceSearch;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @CrossOrigin(origins = "https://hotelapi-backend.herokuapp.com")
    @PostMapping("/api/find_rooms")
    public List<Reservation> getAvailableRoomsBetweenDates(@RequestBody TwoDatesSearch twoDatesSearch) {
        return reservationService.findAvailableRoomsBetweenDates(twoDatesSearch);
    }

    @PostMapping("/api/find_rooms")
    public List<Reservation> getAvailableRoomsBewtweenDatesAndWithinPrice(@RequestBody TwoDatesAndTwoPriceSearch twoDatesAndTwoPriceSearch) {
        return reservationService.findAvailableRoomsBetweenDatesAndPrices(twoDatesAndTwoPriceSearch);
    }

    @CrossOrigin(origins = "https://hotelapi-backend.herokuapp.com/*")
    @PostMapping("/api/reservation/add")
    public Reservation addReservation(@RequestBody ReservationDTO reservation) {
        return reservationService.addReservation(reservation);
    }


}
