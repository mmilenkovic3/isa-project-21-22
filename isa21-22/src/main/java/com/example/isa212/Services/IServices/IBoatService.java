package com.example.isa212.Services.IServices;

import com.example.isa212.Model.Boat;
import com.example.isa212.Model.Cottage;

import java.util.List;

public interface IBoatService {

    List<Boat> findAll();
    Boat findOneById(int id);

    List<Boat> sortByNameAsc(List<Boat> boats);
    List<Boat> sortByNameDesc(List<Boat> boats);
    List<Boat> sortByAddressAsc(List<Boat> boats);
    List<Boat> sortByAddressDesc(List<Boat> boats);
    List<Boat> sortByGradeAsc(List<Boat> boats);
    List<Boat> sortByGradeDesc(List<Boat> boats);
}
