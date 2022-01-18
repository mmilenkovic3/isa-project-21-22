package com.example.isa212.Controllers;

import com.example.isa212.Model.Adventure;
import com.example.isa212.Model.Boat;
import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.DTOs.ReservationParamsDTO;
import com.example.isa212.Services.Implementations.AdventureService;
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
@RequestMapping(value="/adventure", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AdventureController {
    @Autowired
    private AdventureService adventureService;

    @PostMapping(value = "/sortByNameAsc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Adventure>> sortByNameAsc(@RequestBody List<Adventure> adventureList)
    {
        List<Adventure> adventures = adventureService.sortByNameAsc(adventureList);
        return new ResponseEntity<>( adventures, HttpStatus.OK);
    }

    @PostMapping(value = "/sortByNameDesc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Adventure>> sortByNameDesc(@RequestBody List<Adventure> adventureList)
    {
        List<Adventure> adventures = adventureService.sortByNameDesc(adventureList);
        return new ResponseEntity<>( adventures, HttpStatus.OK);
    }

    @PostMapping(value = "/sortByGradeAsc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Adventure>> sortByGradeAsc(@RequestBody List<Adventure> adventureList)
    {
        List<Adventure> adventures = adventureService.sortByGradeAsc(adventureList);
        return new ResponseEntity<>( adventures, HttpStatus.OK);
    }
    @PostMapping(value = "/sortByGradeDesc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Adventure>> sortByGradeDesc(@RequestBody List<Adventure> adventureList)
    {
        List<Adventure> adventures = adventureService.sortByGradeDesc(adventureList);
        return new ResponseEntity<>( adventures, HttpStatus.OK);
    }

    @PostMapping(value = "/sortByAddressDesc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Adventure>> sortByAddressDesc(@RequestBody List<Adventure> adventures)
    {
        List<Adventure> adventureList = adventureService.sortByAddressDesc(adventures);
        return new ResponseEntity<>( adventureList, HttpStatus.OK);
    }

    @PostMapping(value = "/sortByAddressAsc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Adventure>> sortByAddressAsc(@RequestBody List<Adventure> adventures)
    {
        List<Adventure> adventureList = adventureService.sortByAddressAsc(adventures);
        return new ResponseEntity<>( adventureList, HttpStatus.OK);
    }

    @PostMapping(value = "/adventureSearchForReservation")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Adventure>> adventureSearchForReservation(@RequestBody ReservationParamsDTO reservationParamsDTO)
    {
        List<Adventure> adventures = adventureService.getFreeReservationDate(reservationParamsDTO);
        return new ResponseEntity<>( adventures, HttpStatus.OK);
    }

    @PostMapping(value = "/adventureSearchForReservationAction")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Adventure>> adventureSearchForReservationAction()
    {
        List<Adventure> adventures = adventureService.freeReservationAdventureAction();
        return new ResponseEntity<>( adventures, HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Adventure>> findAllBoats()
    {
        System.out.println("Return list off all adveture!");
        List<Adventure> adventures = adventureService.findAll();
        return new ResponseEntity<>( adventures, HttpStatus.OK);
    }
    @PostMapping(value = "/findById/{id}")
    public ResponseEntity<Adventure> findById(@PathVariable int id)
    {
        Adventure adventure = adventureService.findOneById(id);
        return adventure != null ? new ResponseEntity<>( adventure, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
