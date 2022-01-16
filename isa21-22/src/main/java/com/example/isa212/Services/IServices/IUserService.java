package com.example.isa212.Services.IServices;

import com.example.isa212.Model.DTOs.PasswordDTO;
import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.UserTokenState;
import com.example.isa212.Model.Users.Users;
import com.google.zxing.WriterException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface IUserService {

    Users save(UserDTO userDTO) throws MessagingException, IOException, WriterException;
    Users save(Users users);

    void update(Users user);
    Users getUserByID(int ID);
    void changeAccoundEnabledStatus(int user_id);
    UserTokenState Login(String email, String password);
    Users getLoggedUser();
    Users editUser(UserDTO userDTO);
    Users changePassword(PasswordDTO passwordDTO);


}
