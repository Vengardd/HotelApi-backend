package com.spaghettiteam.hotelapi.repository;

import com.spaghettiteam.hotelapi.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
