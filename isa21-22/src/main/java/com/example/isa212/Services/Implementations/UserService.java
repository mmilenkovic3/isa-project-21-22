package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.Users.User;
import com.example.isa212.Repositories.UserRepository;
import com.example.isa212.Services.IServices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(UserDTO userDTO) {
        /*List<Authority> auth = authService.findByname("ROLE_USER");

        for(User u : userRepository.findAll()) {
            if(u.getEmail().equals(user.getEmail()))
                return null;
        }*/

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

        userRepository.save(user);
        return user;
    }

    @Override
    public void update(User user) {

    }
}
