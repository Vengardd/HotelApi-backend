package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.dto.SearchDTO;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/api/findrooms")
    private List<Room> findAvailableRooms(@RequestBody SearchDTO searchDTO) {
        return searchService.findRooms(searchDTO);
    }
}
