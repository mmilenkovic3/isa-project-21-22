package com.example.isa212.Repositories;


import com.example.isa212.Model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findOneById(Integer user_id);
    User findByEmail(String email);

}
