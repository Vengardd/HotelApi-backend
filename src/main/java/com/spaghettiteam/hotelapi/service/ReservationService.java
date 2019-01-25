package com.spaghettiteam.hotelapi.service;

import com.spaghettiteam.hotelapi.dto.ReservationDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.repository.reservation.ReservationCrudRepository;
import com.spaghettiteam.hotelapi.repository.reservation.ReservationRepository;
import com.spaghettiteam.hotelapi.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {


    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;

    @Autowired
    private Validator<TwoDatesSearch> twoDatesSearchValidator;

    public List<Reservation> findAvailableRoomsBetweenDates(TwoDatesSearch twoDatesSearch) {
        twoDatesSearchValidator.validate(twoDatesSearch);
        return reservationRepository.findAllAvaibleRoomsBetweendDates(twoDatesSearch.getStartDate(), twoDatesSearch.getEndDate());
    }

    public Reservation addReservation(ReservationDTO reservationDTO) {
        twoDatesSearchValidator.validate(new TwoDatesSearch(reservationDTO.getStartDate(), reservationDTO.getEndDate()));
        return reservationRepository.save(Reservation.ReservationBuilder.aReservation()
                .withUser(userService.findById(reservationDTO.getUserId()))
                .withRoom(roomService.findById(reservationDTO.getRoomId()))
                .withStartDate(reservationDTO.getStartDate())
                .build());
    }
}