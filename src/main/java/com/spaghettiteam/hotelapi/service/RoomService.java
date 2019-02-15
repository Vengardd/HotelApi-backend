package com.spaghettiteam.hotelapi.service;

import com.spaghettiteam.hotelapi.dto.RoomDTO;
import com.spaghettiteam.hotelapi.exception.RoomAlreadyExistException;
import com.spaghettiteam.hotelapi.exception.RoomNotFoundException;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.repository.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room findById(long id) {
        return roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
    }

   public Room findByRoomNumber(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber).orElseThrow(RoomNotFoundException::new);
    }

   public Optional<Room> findByRoomNumberWOException(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    public Room addRoom(RoomDTO room) {
        if(!findByRoomNumberWOException(room.getRoomNumber()).isPresent())
            return roomRepository.save(new Room(room.getRoomNumber(), room.getPricePerDay()));
        throw new RoomAlreadyExistException();
    }

    public Room deleteRoomById(long id) {
        Room room = roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
        roomRepository.deleteById(id);
        return room;
    }

    public Room updateRoomById(long id, Room newRoom) {
        Room room = roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
        roomRepository.updateById(id, newRoom);
        return room;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }
}
