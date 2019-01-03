package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.dto.RoomDTO;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("api/room/add")
    public Room addRoom(@RequestBody RoomDTO roomDTO) {
        return roomService.addRoom(roomDTO);
    }
}
