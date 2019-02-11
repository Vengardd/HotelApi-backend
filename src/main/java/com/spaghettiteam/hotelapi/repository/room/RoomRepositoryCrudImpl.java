package com.spaghettiteam.hotelapi.repository.room;

import com.spaghettiteam.hotelapi.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepositoryCrudImpl implements RoomRepository {

    @Autowired
    private RoomCrudRepository roomCrudRepository;

    @Override
    public Optional<Room> findByRoomNumber(String roomNumber) {
        return roomCrudRepository.findByRoomNumber(roomNumber);
    }

    @Override
    public Optional<Room> findById(long id) {
        return roomCrudRepository.findById(id);
    }

    @Override
    public Room save(Room room) {
        return roomCrudRepository.save(room);
    }

    @Override
    public List<Room> findRoomsWithinPrice(long startPrice, long endPrice) {
        return roomCrudRepository.findAllByPricePerDayGreaterThanEqualAndPricePerDayIsLessThanEqual(startPrice, endPrice);
    }
}
