package com.example.isa212.Services.IServices;

import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.Users.Client;

public interface IClientService {
    Client subsribeOnCottage(int cottage_id);
    Client findById(int id);
}
