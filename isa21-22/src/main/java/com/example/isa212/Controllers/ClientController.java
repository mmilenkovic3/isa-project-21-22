package com.example.isa212.Controllers;

import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.Users.Client;
import com.example.isa212.Services.Implementations.ClientService;
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
@RequestMapping(value="/client", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ClientController {
    @Autowired
    private ClientService clientService;


    @PostMapping(value = "/subscribeCottage/{cottage_id}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<Client> subscribeCottage(@PathVariable int cottage_id)
    {
        Client client = clientService.subsribeOnCottage(cottage_id);

        return client != null ? new ResponseEntity<Client>( client, HttpStatus.OK) :
                new ResponseEntity("You are allready subscribe on this cottage", HttpStatus.BAD_REQUEST);
    }

}
