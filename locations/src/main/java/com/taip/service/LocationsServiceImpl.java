package com.taip.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taip.models.Location;
import com.taip.service.interfaces.LocationsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LocationsServiceImpl implements LocationsService {

    private static final String WEBSITE_LINK = "http://iasi.inoras.ro/locuri/";

    @Override
    public List<Location> getLocationsFromIasi() throws IOException {

        List<Location> locations = new ArrayList<>();

        for(int i = 1 ; i <= 5; i++ ){
            Document doc = null;

            doc = Jsoup.connect(WEBSITE_LINK + i + "/").get();

            Elements elements = doc.select("ul.loc_list > li");

            for (int j = 0; j < elements.size(); j++) {
                Location location = new Location();
                location.setName(elements.get(j).select("h2").text());
                location.setLink(elements.get(j).select("h2").select("a").attr("href"));
                location.setInfo(elements.get(j).select("p").text());

                locations.add(location);
            }
        }

        return locations;
    }
}
