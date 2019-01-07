package com.taip.web.rest.controllers;

import com.taip.models.Location;
import com.taip.service.interfaces.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "locations")
public class LocationsController {

    @Autowired
    LocationsService locationsService;

    @GetMapping
    public @ResponseBody ResponseEntity<List<Location>> getLocations() throws IOException {

        System.out.println("Called endpoint");

        List<Location> locations = locationsService.getLocationsFromIasi();
        return new ResponseEntity<>(locations, org.springframework.http.HttpStatus.OK);
    }

}
