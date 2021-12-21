package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.Users.Authority;
import com.example.isa212.Model.Users.User;
import com.example.isa212.Repositories.UserRepository;
import com.example.isa212.Services.IServices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public User save(UserDTO userDTO) {
        List<Authority> authority = authorityService.findByName("ROLE_USER");

        for(User u : userRepository.findAll()) {
            if(u.getEmail().equals(userDTO.getEmail()))
                return null;
        }

        User user = new User(
                userDTO.getName(),
                userDTO.getSurname(),
                userDTO.getEmail(),
                passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getAddress(),
                userDTO.getPhoneNumber(),
                userDTO.getCity(),
                userDTO.getCountry());

        user.setAccountEnabled(true);
        user.setAuthorities(authority);

        userRepository.save(user);
        return user;
    }

    @Override
    public void update(User user) {

    }
}
