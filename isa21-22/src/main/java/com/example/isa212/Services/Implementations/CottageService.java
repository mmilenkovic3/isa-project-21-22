package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Cottage;
import com.example.isa212.Repositories.CottageRepository;
import com.example.isa212.Services.IServices.ICottageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CottageService implements ICottageService {

    @Autowired
    private CottageRepository cottageRepository;

    @Override
    public List<Cottage> findAll() {
        return cottageRepository.findAll();
    }

    @Override
    public Cottage findOneByid_cottage(int id) {
        return null;
    }
}
