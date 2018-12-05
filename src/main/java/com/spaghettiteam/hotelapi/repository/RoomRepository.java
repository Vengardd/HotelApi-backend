package com.spaghettiteam.hotelapi.repository;

import com.spaghettiteam.hotelapi.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
