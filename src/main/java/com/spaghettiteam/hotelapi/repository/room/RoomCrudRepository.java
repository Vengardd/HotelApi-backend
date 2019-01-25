package com.spaghettiteam.hotelapi.repository.room;

import com.spaghettiteam.hotelapi.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomCrudRepository extends CrudRepository<Room, Long> {
    Optional<Room> findByRoomNumber(String roomNumber);
}
