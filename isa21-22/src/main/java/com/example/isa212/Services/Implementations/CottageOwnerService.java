package com.example.isa212.Services.Implementations;

import com.example.isa212.Repositories.CottageOwnerRepository;
import com.example.isa212.Services.IServices.ICottageOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CottageOwnerService implements ICottageOwnerService {
    @Autowired
    private CottageOwnerRepository cottageOwnerRepository;


}
