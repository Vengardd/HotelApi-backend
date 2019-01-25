package com.spaghettiteam.hotelapi.repository.reservation;

import com.spaghettiteam.hotelapi.model.Reservation;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository {
    List<Reservation> findAllAvaibleRoomsBetweendDates(@Param("start") LocalDate startDate, @Param("end") LocalDate endDate);
    Reservation save(Reservation reservation);
}
