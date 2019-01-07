package com.taip.service.interfaces;

import com.taip.models.Location;

import java.io.IOException;
import java.util.List;

public interface LocationsService {

    List<Location> getLocationsFromIasi() throws IOException;

}
