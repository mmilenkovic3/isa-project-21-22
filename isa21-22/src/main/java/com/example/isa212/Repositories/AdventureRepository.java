package com.example.isa212.Repositories;

import com.example.isa212.Model.Adventure;
import com.example.isa212.Model.Users.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdventureRepository extends JpaRepository<Adventure, Integer> {


}
