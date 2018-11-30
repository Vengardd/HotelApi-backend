package com.spaghettiteam.hotelapi.repository;

import com.spaghettiteam.hotelapi.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    //ToDo comparing dates its not working, make this works
    @Query(value = "select r from Room r where r.id not in " +
            "(select distinct room from Reservation re " +
            "where (:start >= re.startDate OR :start < re.endDate) OR (:end >= re.startDate OR :end < re.endDate))")
    List<Reservation> findAllAvaibleRoomsBetweendDates(@Param("start") LocalDate startDate, @Param("end") LocalDate endDate);


    @Query(value = "select room from Reservation r where " +
            "(:start >= r.startDate AND :start <= r.endDate) OR (:end >= r.startDate AND :end <= r.endDate) " +
            "OR (:start < r.startDate AND :end > r.endDate)")
    List<Reservation> test(@Param("start") LocalDate startDate, @Param("end") LocalDate endDate);


    @Query(value = "select r from Reservation r where " +
            "(:start > r.startDate)")
    List<Reservation> test2(@Param("start") LocalDate startDate);
}
