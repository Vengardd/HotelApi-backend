package com.spaghettiteam.hotelapi.service;

import com.spaghettiteam.hotelapi.dto.RoomDTO;
import com.spaghettiteam.hotelapi.exception.RoomAlreadyExistException;
import com.spaghettiteam.hotelapi.exception.RoomNotFoundException;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.repository.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room findById(long id) {
        return roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
    }

    private Room findByRoomNumber(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber).orElseThrow(RoomNotFoundException::new);
    }

    public List<Room> findRoomsWithinPrice(long startPrice, long endPrice) {
        List<Room> rooms = roomRepository.findRoomsWithinPrice(startPrice, endPrice);
        if (rooms != null)
            return rooms;
        throw new RoomNotFoundException();
    }

    //ToDo refactore, looks bad
    public Room addRoom(RoomDTO room) {
        try {
            findByRoomNumber(room.getRoomNumber());
        } catch (RoomNotFoundException e) {
            return roomRepository.save(new Room(room.getRoomNumber()));
        }
        throw new RoomAlreadyExistException();
    }
}
