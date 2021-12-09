package com.example.isa212.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.isa212.Model.Users.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Authority findByName(String name);

}
