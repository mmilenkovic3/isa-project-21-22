package com.example.isa212.Services.Implementations;

import com.example.isa212.Repositories.BoatOwnerRepository;
import com.example.isa212.Services.IServices.IBoatOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoatOwnerService implements IBoatOwnerService {
    @Autowired
    private BoatOwnerRepository boatOwnerRepository;
}
