package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
