package com.spaghettiteam.hotelapi.service;

import com.spaghettiteam.hotelapi.dto.ReservationDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.repository.ReservationRepository;
import com.spaghettiteam.hotelapi.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private Validator<TwoDatesSearch> twoDatesSearchValidator;

    public List<Reservation> findAvailableRoomsBetweenDates(TwoDatesSearch twoDatesSearch) {
        twoDatesSearchValidator.validate(twoDatesSearch);
        return reservationRepository.findAllAvaibleRoomsBetweendDates(twoDatesSearch.getStartDate(), twoDatesSearch.getEndDate());
    }

    public Reservation addReservation(ReservationDTO reservation) {
        twoDatesSearchValidator.validate(new TwoDatesSearch(reservation.getStartDate(), reservation.getEndDate()));
        userService.findById(reservation.getUserId());
        return new Reservation();
    }
}
