package com.example.isa212.Controllers;

import com.example.isa212.Model.ClientReservation;
import com.example.isa212.Services.Implementations.ClientReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value="/cr", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ClientReservationController {
    @Autowired
    private ClientReservationService clientReservationService;







}
