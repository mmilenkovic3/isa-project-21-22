package com.example.isa212.Services.IServices;

import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.Users.User;

public interface IUserService {

    User save(UserDTO userDTO);
    void update(User user);


}
