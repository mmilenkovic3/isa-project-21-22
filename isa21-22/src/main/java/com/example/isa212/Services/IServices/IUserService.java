package com.example.isa212.Services.IServices;

import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.Users.User;
import com.google.zxing.WriterException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface IUserService {

    User save(UserDTO userDTO) throws MessagingException, IOException, WriterException;
    void update(User user);
    User getUserByID(int ID);
    void changeAccoundEnabledStatus(int user_id);


}
