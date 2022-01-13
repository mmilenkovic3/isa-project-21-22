package com.example.isa212.Repositories;


import com.example.isa212.Model.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findOneById(Integer user_id);
    Users findByEmail(String email);

}
