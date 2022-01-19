package com.example.isa212.Controllers;

import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.Users.Admin;
import com.example.isa212.Model.Users.Users;
import com.example.isa212.Services.Implementations.AdminService;
import com.google.zxing.WriterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping(value="/admin", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value =  "/saveAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Admin> saveAdmin(@RequestBody UserDTO userDTO) throws MessagingException, IOException, WriterException {
        Admin admin = adminService.save(userDTO);
        return admin == null ? new ResponseEntity("User with this email exists", HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(admin, HttpStatus.CREATED);

    }
}
