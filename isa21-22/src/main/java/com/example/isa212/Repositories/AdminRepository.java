package com.example.isa212.Repositories;

import com.example.isa212.Model.Users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Integer> {
}
