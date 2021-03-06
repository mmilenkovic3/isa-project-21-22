package com.example.isa212.Services.IServices;

import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.Users.Client;

import javax.mail.MessagingException;

public interface IClientService {
    Client subsribeOnCottage(int cottage_id ,int user_id);

    Client save(Client client);
    Client findById(int id);


    // Client save(UserDTO client) throws MessagingException;
}
