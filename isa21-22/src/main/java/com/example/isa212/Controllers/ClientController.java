package com.example.isa212.Controllers;

import com.example.isa212.Model.ClientReservation;
import com.example.isa212.Model.DTOs.ClientAllReservationDTO;
import com.example.isa212.Model.Enums.ReservationCancelType;
import com.example.isa212.Model.Users.Client;
import com.example.isa212.Repositories.ClientReservationService;
import com.example.isa212.Services.Implementations.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@CrossOrigin
@RequestMapping(value="/client", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientReservationService clientReservationService;


    @PostMapping(value = "/subscribeCottage/{cottage_id}/{user_id}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<Client> subscribeCottage(@PathVariable int cottage_id, @PathVariable int user_id)
    {
        Client client = clientService.subsribeOnCottage(cottage_id, user_id);

        return client != null ? new ResponseEntity<Client>( client, HttpStatus.OK) :
                new ResponseEntity("You are allready subscribe on this cottage", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/unsubscribeCottage/{cottage_id}/{user_id}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<Client> unsubscribeCottage(@PathVariable int cottage_id, @PathVariable int user_id)
    {
        Client client = clientService.unsubsribeOnCottage(cottage_id, user_id);

        return client != null ? new ResponseEntity<Client>( client, HttpStatus.OK) :
                new ResponseEntity("Unsubscribe already!", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/subscribeBoat/{boat_id}/{user_id}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<Client> subscribeBoat(@PathVariable int boat_id, @PathVariable int user_id)
    {
        Client client = clientService.subsribeOnBoat(boat_id, user_id);

        return client != null ? new ResponseEntity<Client>( client, HttpStatus.OK) :
                new ResponseEntity("You are allready subscribe on this boat", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/unsubscribeBoat/{boat_id}/{user_id}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<Client> unsubscribeBoat(@PathVariable int boat_id, @PathVariable int user_id)
    {
        Client client = clientService.unsubsribeOnBoat(boat_id, user_id);

        return client != null ? new ResponseEntity<Client>( client, HttpStatus.OK) :
                new ResponseEntity("Unsubscribe already!", HttpStatus.BAD_REQUEST);
    }


    @PostMapping(value = "/subscribeAdventure/{adventure_id}/{user_id}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<Client> subscribeAdventure(@PathVariable int adventure_id, @PathVariable int user_id)
    {
        Client client = clientService.subsribeOnAdventure(adventure_id, user_id);

        return client != null ? new ResponseEntity<Client>( client, HttpStatus.OK) :
                new ResponseEntity("You are allready subscribe on this adventure", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/unsubscribeAdventure/{adventure_id}/{user_id}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<Client> unsubscribeAdventure(@PathVariable int adventure_id, @PathVariable int user_id)
    {
        Client client = clientService.unsubsribeOnAdventure(adventure_id, user_id);

        return client != null ? new ResponseEntity<Client>( client, HttpStatus.OK) :
                new ResponseEntity("Unsubscribe already!", HttpStatus.BAD_REQUEST);
    }


    @PostMapping(value = "/reservation/{client_id}/{reservation_id}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity reserveCottage(@PathVariable int client_id, @PathVariable int reservation_id) throws MessagingException {
        clientService.reserve(client_id, reservation_id);
        return new ResponseEntity("Successeffully reserved cottage.", HttpStatus.OK);
    }

    @PostMapping(value = "/getLoggedClient/{client_id}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<ClientAllReservationDTO> getLoggedClient(@PathVariable int client_id){
        ClientAllReservationDTO bigList =  clientService.findAllClientReservation(client_id);
        return bigList != null ? new ResponseEntity(bigList, HttpStatus.OK) :
                new ResponseEntity(HttpStatus.BAD_REQUEST);

    }

    @PostMapping(value = "/reservationStatus/{client_id}/{reservation_id")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<String> reservationStatus(@PathVariable int client_id, @PathVariable int reservation_id){
        ReservationCancelType cancelTyp =  clientReservationService.getReservationCancelType(client_id, reservation_id);
        return cancelTyp.name() != null ? new ResponseEntity(cancelTyp.name(), HttpStatus.OK) :
                new ResponseEntity(HttpStatus.BAD_REQUEST);

    }






}
