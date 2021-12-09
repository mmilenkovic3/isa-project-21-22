package com.example.isa212.Services.IServices;
import com.example.isa212.Model.Users.Authority;
import java.util.List;

public interface IAuthorityService {

    List<Authority> findById(Integer id);
    List<Authority> findByName(String name);
}
