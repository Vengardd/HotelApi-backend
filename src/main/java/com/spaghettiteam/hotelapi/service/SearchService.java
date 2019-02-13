package com.spaghettiteam.hotelapi.service;

import com.spaghettiteam.hotelapi.dto.SearchDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesAndTwoPriceSearch;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.exception.RoomNotFoundException;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.repository.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findRooms(SearchDTO search) {
        return roomRepository.findAvailableRooms(search.setLowestPrice(), search.getHighestPrice(), search.getStartDate(), search.getEndDate());
    }

    public List<Reservation> findAvailableRoomsBetweenDates(TwoDatesSearch twoDatesSearch) {
        twoDatesSearchValidator.validate(twoDatesSearch);
        return reservationRepository.findAllAvaibleRoomsBetweendDates(twoDatesSearch.getStartDate(), twoDatesSearch.getEndDate());
    }


    public List<Reservation> findAvailableRoomsBetweenDatesAndPrices(TwoDatesAndTwoPriceSearch twoDatesAndTwoPriceSearch) {
//        twoDatesAndTwoPriceSearchValidator.validate(twoDatesAndTwoPriceSearch);
        long days = countDaysFromTwoDatesSearch(twoDatesAndTwoPriceSearch.getTwoDates());
        long lowestPriceMuliplied = twoDatesAndTwoPriceSearch.getTwoPrices().getLowestPrice() * days;
        long highestPriceMultiplied = twoDatesAndTwoPriceSearch.getTwoPrices().getHighestPrice() * days;
        return reservationRepository.findAllAvaibleRoomsBetweendDatesAndWithinPrice(
                twoDatesAndTwoPriceSearch.getTwoDates().getStartDate(), twoDatesAndTwoPriceSearch.getTwoDates().getEndDate(),
                lowestPriceMuliplied, highestPriceMultiplied);
    }

    public List<Room> findRoomsWithinPrice(long startPrice, long endPrice) {
        List<Room> rooms = roomRepository.findRoomsWithinPrice(startPrice, endPrice);
        if (rooms != null)
            return rooms;
        throw new RoomNotFoundException();
    }
}
