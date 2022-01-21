package com.example.isa212.Controllers;

import com.example.isa212.Services.Implementations.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value="/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


}
