package com.spaghettiteam.hotelapi.service;

import com.spaghettiteam.hotelapi.dto.SearchDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesAndTwoPriceSearch;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.exception.RoomNotFoundException;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.repository.reservation.ReservationRepository;
import com.spaghettiteam.hotelapi.repository.room.RoomRepository;
import com.spaghettiteam.hotelapi.validation.TwoDatesSearchValidator;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class SearchService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private TwoDatesSearchValidator twoDatesSearchValidator;
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Room> findRooms(SearchDTO search) {
        return roomRepository.findAvailableRooms(search.getLowestPrice(), search.getHighestPrice(), search.getStartDate(), search.getEndDate());
    }

    @Deprecated
    public List<Reservation> findAvailableRoomsBetweenDates(TwoDatesSearch twoDatesSearch) {
        twoDatesSearchValidator.validate(twoDatesSearch);
        return reservationRepository.findAllAvaibleRoomsBetweendDates(twoDatesSearch.getStartDate(), twoDatesSearch.getEndDate());
    }

    @Deprecated
    public List<Reservation> findAvailableRoomsBetweenDatesAndPrices(TwoDatesAndTwoPriceSearch twoDatesAndTwoPriceSearch) {
//        twoDatesAndTwoPriceSearchValidator.validate(twoDatesAndTwoPriceSearch);
        long days = countDaysFromTwoDatesSearch(twoDatesAndTwoPriceSearch.getTwoDates());
        long lowestPriceMuliplied = twoDatesAndTwoPriceSearch.getTwoPrices().getLowestPrice() * days;
        long highestPriceMultiplied = twoDatesAndTwoPriceSearch.getTwoPrices().getHighestPrice() * days;
        return reservationRepository.findAllAvaibleRoomsBetweendDatesAndWithinPrice(
                twoDatesAndTwoPriceSearch.getTwoDates().getStartDate(), twoDatesAndTwoPriceSearch.getTwoDates().getEndDate(),
                lowestPriceMuliplied, highestPriceMultiplied);
    }
    @Deprecated
    public List<Room> findRoomsWithinPrice(long startPrice, long endPrice) {
        List<Room> rooms = roomRepository.findRoomsWithinPrice(startPrice, endPrice);
        if (rooms != null)
            return rooms;
        throw new RoomNotFoundException();
    }

    private long countDaysFromTwoDatesSearch(TwoDatesSearch twoDatesSearch) {
        return DAYS.between(twoDatesSearch.getStartDate(), twoDatesSearch.getStartDate());
    }
}
