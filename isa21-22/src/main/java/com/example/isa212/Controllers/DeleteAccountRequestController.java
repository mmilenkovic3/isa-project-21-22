package com.example.isa212.Controllers;

import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.DTOs.DeleteReqDTO;
import com.example.isa212.Model.DeleteAccountRequest;
import com.example.isa212.Services.Implementations.DeleteAccountRequestService;
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
@RequestMapping(value="/deleteAcc", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class DeleteAccountRequestController {
    @Autowired
    private DeleteAccountRequestService deleteAccountRequestService;


    @PostMapping(value = "/sendRequest/{id}/{text}")
    @PreAuthorize("hasRole('USERS')")
    public ResponseEntity sendRequest(@PathVariable int id, @PathVariable String text) throws MessagingException {   Boolean isTrue = deleteAccountRequestService.SendRequestForDelete(id, text);

        return isTrue  ? new ResponseEntity<>( "Saved request for delete!", HttpStatus.OK)
                : new ResponseEntity<>("Error. Or you send request for delete, or you have some reservation that didnt happeneed. ", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<DeleteReqDTO>> getAll()
    {
        List<DeleteReqDTO> d = deleteAccountRequestService.getAllDeleteRA();
        return d != null ? new ResponseEntity<List<DeleteReqDTO>>(d, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/approve/{id_delete}/{text}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity approve(@PathVariable int id_delete, @PathVariable String text) throws MessagingException {
        deleteAccountRequestService.approveDeleteAccount(id_delete,text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/disapprove/{id_delete}/{text}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity disapprove(@PathVariable int id_delete, @PathVariable String text) throws MessagingException {
        deleteAccountRequestService.disapproveDeleteAccount(id_delete,text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
