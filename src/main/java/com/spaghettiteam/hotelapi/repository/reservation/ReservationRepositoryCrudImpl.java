package com.spaghettiteam.hotelapi.repository.reservation;

import com.spaghettiteam.hotelapi.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ReservationRepositoryCrudImpl implements ReservationRepository {

    @Autowired
    private ReservationCrudRepository repository;

    @Override
    public List<Reservation> findAllAvaibleRoomsBetweendDates(LocalDate startDate, LocalDate endDate) {
        return repository.findAllAvaibleRoomsBetweendDates(startDate, endDate);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }
}
