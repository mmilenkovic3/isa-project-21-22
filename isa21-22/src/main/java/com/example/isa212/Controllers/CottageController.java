package com.example.isa212.Controllers;

import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.Users.Users;
import com.example.isa212.Services.Implementations.CottageService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CottageController {

    @Autowired
    private CottageService cottageService;

    @GetMapping(value = "/findAll")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<Cottage>> findAllCottage()
    {
        System.out.println("Find all cottage?");
        List<Cottage> cottages = cottageService.findAll();
        return new ResponseEntity<>( cottages, HttpStatus.OK);
    }

    @GetMapping(value = "/try")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> proba()
    {
        System.out.println("Admin pozvao ovo?");

        return new ResponseEntity<String>("AUTH", HttpStatus.OK);
    }


}
