package com.example.isa212.Controllers;

import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.Users.User;
import com.example.isa212.Services.Implementations.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value="/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value =  "/saveUser")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO) {
        User user = userService.save(userDTO);
        return user == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(user, HttpStatus.CREATED);

    }


}
