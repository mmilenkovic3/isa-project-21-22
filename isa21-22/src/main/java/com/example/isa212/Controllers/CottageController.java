package com.example.isa212.Controllers;

import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.DTOs.ReservationParamsDTO;
import com.example.isa212.Services.Implementations.CottageService;
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
@RequestMapping(value="/cottage", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class CottageController {

    @Autowired
    private CottageService cottageService;

    @GetMapping(value = "/findAll")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Cottage>> findAllCottage()
    {
        System.out.println("Return list off all cotages!");
        List<Cottage> cottages = cottageService.findAll();
        return new ResponseEntity<>( cottages, HttpStatus.OK);
    }

    @PostMapping(value = "/sortByNameAsc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Cottage>> sortByNameAsc(@RequestBody List<Cottage> cottages_list)
    {
        List<Cottage> cottages = cottageService.sortByNameAsc(cottages_list);
        return new ResponseEntity<>( cottages, HttpStatus.OK);
    }

    @PostMapping(value = "/sortByNameDesc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Cottage>> sortByNameDesc(@RequestBody List<Cottage> cottages_list)
    {
        List<Cottage> cottages = cottageService.sortByNameDesc(cottages_list);
        return new ResponseEntity<>( cottages, HttpStatus.OK);
    }
    @PostMapping(value = "/sortByAddressAsc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Cottage>> sortByAddressAsc(@RequestBody List<Cottage> cottages_list)
    {
        List<Cottage> cottages = cottageService.sortByAddressAsc(cottages_list);
        return new ResponseEntity<>( cottages, HttpStatus.OK);
    }
    @PostMapping(value = "/sortByAddressDesc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Cottage>> sortByAddressDesc(@RequestBody List<Cottage> cottages_list)
    {
        List<Cottage> cottages = cottageService.sortByAddressDesc(cottages_list);
        return new ResponseEntity<>( cottages, HttpStatus.OK);
    }
    @PostMapping(value = "/sortByGradeAsc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Cottage>> sortByGradeAsc(@RequestBody List<Cottage> cottages_list)
    {
        List<Cottage> cottages = cottageService.sortByGradeAsc(cottages_list);
        return new ResponseEntity<>( cottages, HttpStatus.OK);
    }
    @PostMapping(value = "/sortByGradeDesc")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Cottage>> sortByGradeDesc(@RequestBody List<Cottage> cottages_list)
    {
        List<Cottage> cottages = cottageService.sortByGradeDesc(cottages_list);
        return new ResponseEntity<>( cottages, HttpStatus.OK);
    }



    @GetMapping(value = "/try")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> proba()
    {
        System.out.println("Admin pozvao ovo?");

        return new ResponseEntity<String>("AUTH", HttpStatus.OK);
    }

    @PostMapping(value = "/cottageSearchForReservation")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Cottage>> cottageSearchForReservation(@RequestBody ReservationParamsDTO reservationParamsDTO)
    {
        List<Cottage> cottages = cottageService.getFreeReservationDate(reservationParamsDTO);
        return new ResponseEntity<>( cottages, HttpStatus.OK);
    }

    @PostMapping(value = "/cottageSearchForReservationAction")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Cottage>> cottageSearchForReservationAction()
    {
        List<Cottage> cottages = cottageService.freeReservationCottageAction();
        return new ResponseEntity<>( cottages, HttpStatus.OK);
    }


}
