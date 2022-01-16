package com.example.isa212.Repositories;


import com.example.isa212.Model.Cottage;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface CottageRepository extends JpaRepository<Cottage, Integer> {
    ArrayList<Cottage> findAll();
    List<Cottage> findAll(Sort sort);




    //Cottage findOneById(Integer id);
    //Cottage findByName(String name);
}
