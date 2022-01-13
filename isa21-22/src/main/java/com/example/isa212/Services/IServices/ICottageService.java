package com.example.isa212.Services.IServices;

import com.example.isa212.Model.Cottage;

import java.util.List;

public interface ICottageService {

    List<Cottage> findAll();
    Cottage findOneByid_cottage(int id);




}
