package com.example.isa212.Controllers;

import com.example.isa212.Model.DTOs.PasswordDTO;
import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.UserTokenState;
import com.example.isa212.Model.Users.Users;
import com.example.isa212.Services.Implementations.UserService;
import com.example.isa212.Utils.Auth.JwtAuthenticationRequest;
import com.google.zxing.WriterException;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping(value="/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserTokenState> login(@NotNull @RequestBody JwtAuthenticationRequest authRequest,
                                                HttpServletResponse response)
    {
        System.out.println("Controller login?");
        System.out.println(authRequest.getUsername());

        UserTokenState token = userService.Login(authRequest.getUsername(), authRequest.getPassword());
        return token == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(token);
    }

    @GetMapping(value = "/loggedUser")
    public ResponseEntity<Users> getLoggedUser()
    {
        System.out.println("Nasao logovanog usera?");

        Users u = userService.getLoggedUser();
        return  u == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(u, HttpStatus.OK);
    }


    @PostMapping(value =  "/saveUser")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Users> saveUser(@RequestBody UserDTO userDTO) throws MessagingException, IOException, WriterException {
        Users user = userService.save(userDTO);
        return user == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(user, HttpStatus.CREATED);

    }

    @PostMapping(value= "/getUserByID/{ID}")

    public ResponseEntity<Users> getUserByID(@PathVariable int ID) {
        Users user = userService.getUserByID(ID);
        return user == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PostMapping(value= "/changeEnabledStatus/{ID}")
    public ResponseEntity changeEnabledStatus(@PathVariable int ID) {
        userService.changeAccoundEnabledStatus(ID);
        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping(value= "/editUser")
    public ResponseEntity changeEnabledStatus(@RequestBody UserDTO userDTO) {
        Users u = userService.editUser(userDTO);
        return u != null ? new ResponseEntity<Users>(u, HttpStatus.OK) :
        new ResponseEntity(HttpStatus.BAD_REQUEST);

    }

    @PostMapping(value= "/changePassword")
    public ResponseEntity changePassword(@RequestBody PasswordDTO passwordDTO) {
        Users u = userService.changePassword(passwordDTO);
        return u != null ? new ResponseEntity<Users>(u, HttpStatus.OK) :
                new ResponseEntity("Password are not maching! ", HttpStatus.BAD_REQUEST);

    }



}
