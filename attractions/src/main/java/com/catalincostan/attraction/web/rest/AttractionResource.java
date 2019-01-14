package com.catalincostan.attraction.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.catalincostan.attraction.domain.Attraction;
import com.catalincostan.attraction.service.AttractionService;
import com.catalincostan.attraction.web.rest.errors.BadRequestAlertException;
import com.catalincostan.attraction.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Attraction.
 */
@RestController
@RequestMapping("/api")
public class AttractionResource {

    private final Logger log = LoggerFactory.getLogger(AttractionResource.class);

    private static final String ENTITY_NAME = "attraction";

    private final AttractionService attractionService;

    public AttractionResource(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    /**
     * GET  /attractions : get all the attractions.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of attractions in body
     */
    @GetMapping("/attractions")
    @Timed
    public List<Attraction> getAllAttractions() {
        log.debug("REST request to get all Attractions");
        return attractionService.findAll();
    }

    /**
     * GET  /attractions/:id : get the "id" attraction.
     *
     * @param id the id of the attraction to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the attraction, or with status 404 (Not Found)
     */
    @GetMapping("/attractions/{id}")
    @Timed
    public ResponseEntity<Attraction> getAttraction(@PathVariable Long id) {
        log.debug("REST request to get Attraction : {}", id);
        Optional<Attraction> attraction = attractionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(attraction);
    }
}
