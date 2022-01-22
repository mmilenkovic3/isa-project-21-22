package com.example.isa212.Controllers;

import com.example.isa212.Model.Complains;
import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.DTOs.ComplainsDTO;
import com.example.isa212.Model.Enums.ReservationType;
import com.example.isa212.Services.Implementations.ComplainsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/complains", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ComplainsController {
    @Autowired
    private ComplainsService complainsService;

    @PostMapping(value = "/cottageNames/{id}/{reservation_type}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<List<String>> cottageNames(@PathVariable int id, @PathVariable String reservation_type)
    {
        ReservationType reservationType = ReservationType.COTTAGE;

        if(reservation_type.equals("BOAT"))
        {
            reservationType = ReservationType.BOAT;
        }else if(reservation_type.equals("ADVENTURE"))
        {
            reservationType = ReservationType.ADVENTURE;
        }

        List<String> names = complainsService.getNames(reservationType, id);
        return new ResponseEntity<>( names, HttpStatus.OK);
    }


    @PostMapping(value = "/saveComplain")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity<Complains> saveComplain(@RequestBody ComplainsDTO complainsDTO) throws MessagingException {
        Complains complains = complainsService.saveComplain(complainsDTO);
        return complains != null ? new ResponseEntity<Complains>( complains, HttpStatus.OK):
        new ResponseEntity<>(HttpStatus.BAD_REQUEST );
    }

    @PostMapping(value = "/answerComplain/{id}/{text}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity answerComplain(@PathVariable int id,@PathVariable String text)
    {
        complainsService.setAnswer(id, text);
        return  new ResponseEntity<>( HttpStatus.OK);

    }

}
