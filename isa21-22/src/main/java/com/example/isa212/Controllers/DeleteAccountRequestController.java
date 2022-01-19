package com.example.isa212.Controllers;

import com.example.isa212.Model.Cottage;
import com.example.isa212.Services.Implementations.DeleteAccountRequestService;
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
@RequestMapping(value="/deleteAcc", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class DeleteAccountRequestController {
    @Autowired
    private DeleteAccountRequestService deleteAccountRequestService;


    @PostMapping(value = "/sendRequest/{id}/{text}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity searchByName(@PathVariable int id, @PathVariable String text)
    {   Boolean isTrue = deleteAccountRequestService.SendRequestForDelete(id, text);

        return isTrue  ? new ResponseEntity<>( "Saved request for delete!", HttpStatus.OK)
                : new ResponseEntity<>("Error. Or you send request for delete, or you have some reservation. ", HttpStatus.BAD_REQUEST);
    }
}
