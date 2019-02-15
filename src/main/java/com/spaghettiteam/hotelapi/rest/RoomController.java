package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.dto.RoomDTO;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/api/room/number/{roomNumber}")
    public Room findByRoomNumber(@PathVariable("roomNumber") String roomNumber) {
        return roomService.findByRoomNumber(roomNumber);
    }

    @GetMapping("/api/room/id/{Id}")
    public Room findById(@PathVariable("Id") long Id) {
        return roomService.findById(Id);
    }

    @GetMapping("/api/room/all")
    public List<Room> findAllRooms() {
        return roomService.findAll();
    }

    @DeleteMapping("/api/room/{Id}")
    public Room deleteRoomId(@PathVariable("Id") long Id) {
        return roomService.deleteRoomById(Id);
    }

    @PostMapping("/api/room/{Id}")
    public Room updateRoomId(@PathVariable("Id") long Id, @RequestBody Room room) {
        return roomService.updateRoomById(Id, room);
    }

    @PostMapping("api/room/add")
    public Room addRoom(@RequestBody RoomDTO roomDTO) {
        return roomService.addRoom(roomDTO);
    }
}
