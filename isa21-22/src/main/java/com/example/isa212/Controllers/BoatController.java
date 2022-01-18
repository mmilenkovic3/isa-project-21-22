package com.example.isa212.Controllers;

import com.example.isa212.Model.Boat;
import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.DTOs.ReservationParamsDTO;
import com.example.isa212.Services.Implementations.BoatService;
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
@RequestMapping(value="/boat", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class BoatController {
    @Autowired
    private BoatService boatService;
    @PostMapping(value = "/boatSearchForReservation")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Boat>> boatSearchForReservation(@RequestBody ReservationParamsDTO reservationParamsDTO)
    {
        List<Boat> boats = boatService.getFreeBoatReservation(reservationParamsDTO);
        return new ResponseEntity<>( boats, HttpStatus.OK);
    }
    @PostMapping(value = "/sortByNameAsc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Boat>> sortByNameAsc(@RequestBody List<Boat> boat_list)
    {
        List<Boat> boats = boatService.sortByNameAsc(boat_list);
        return new ResponseEntity<>( boats, HttpStatus.OK);
    }

    @PostMapping(value = "/sortByNameDesc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Boat>> sortByNameDesc(@RequestBody List<Boat> boat_list)
    {
        List<Boat> boats = boatService.sortByNameDesc(boat_list);
        return new ResponseEntity<>( boats, HttpStatus.OK);
    }

    @PostMapping(value = "/sortByAddressAsc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Boat>> sortByAddressAsc(@RequestBody List<Boat> boat_list)
    {
        List<Boat> boats = boatService.sortByAddressAsc(boat_list);
        return new ResponseEntity<>( boats, HttpStatus.OK);
    }
    @PostMapping(value = "/sortByAddressDesc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Boat>> sortByAddressDesc(@RequestBody List<Boat> boat_list)
    {
        List<Boat> boats = boatService.sortByAddressDesc(boat_list);
        return new ResponseEntity<>( boats, HttpStatus.OK);
    }

    @PostMapping(value = "/sortByGradeAsc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Boat>> sortByGradeAsc(@RequestBody List<Boat> boat_list)
    {
        List<Boat> boats = boatService.sortByGradeAsc(boat_list);
        return new ResponseEntity<>( boats, HttpStatus.OK);
    }

    @PostMapping(value = "/sortByGradeDesc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Boat>> sortByGradeDesc(@RequestBody List<Boat> boat_list)
    {
        List<Boat> boats = boatService.sortByGradeDesc(boat_list);
        return new ResponseEntity<>( boats, HttpStatus.OK);
    }

    @PostMapping(value = "/boateSearchForReservationAction")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Boat>> boateSearchForReservationAction()
    {
        List<Boat> boats = boatService.freeReservationBoatAction();
        return new ResponseEntity<>( boats, HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Boat>> findAllBoats()
    {
        System.out.println("Return list off all boats!");
        List<Boat> boatList = boatService.findAll();
        return new ResponseEntity<>( boatList, HttpStatus.OK);
    }


}
