package com.example.isa212.Controllers;


import com.example.isa212.Model.DTOs.ActionReservationAdventureDTO;
import com.example.isa212.Model.DTOs.ActionReservationBoatDTO;
import com.example.isa212.Model.DTOs.ActionReservationCottageDTO;
import com.example.isa212.Services.Implementations.ActionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/action", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ActionsController {

    @Autowired
    private ActionsService actionsService;

    @PostMapping(value = "/getAllAction/{id}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<ActionReservationCottageDTO>> getAllAction(@PathVariable int id)
    {
        List<ActionReservationCottageDTO> actionsList = actionsService.findAll(id);

        return actionsList != null ? new ResponseEntity<List<ActionReservationCottageDTO>>( actionsList, HttpStatus.OK) :
                new ResponseEntity("Actions doesnt exists", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/getAllBoatAction/{id}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<ActionReservationBoatDTO>> getAllBoatAction(@PathVariable int id)
    {
        List<ActionReservationBoatDTO> actionsList = actionsService.findAllBoat(id);

        return actionsList != null ? new ResponseEntity<List<ActionReservationBoatDTO>>( actionsList, HttpStatus.OK) :
                new ResponseEntity("Actions doesnt exists", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/getAllAdventureAction/{id}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<ActionReservationAdventureDTO>> getAllAdventureAction(@PathVariable int id)
    {
        List<ActionReservationAdventureDTO> actionsList = actionsService.findAllAdventure(id);

        return actionsList != null ? new ResponseEntity<List<ActionReservationAdventureDTO>>( actionsList, HttpStatus.OK) :
                new ResponseEntity("Actions doesnt exists", HttpStatus.BAD_REQUEST);
    }


}
