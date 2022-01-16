package com.example.isa212.Repositories;

import com.example.isa212.Model.Boat;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoatRepository extends JpaRepository<Boat, Integer> {
    List<Boat> findAll();
    List<Boat> findAll(Sort sort);
}
