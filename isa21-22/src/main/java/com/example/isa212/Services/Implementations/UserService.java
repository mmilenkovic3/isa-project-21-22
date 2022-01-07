package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.Users.Authority;
import com.example.isa212.Model.Users.User;
import com.example.isa212.Repositories.UserRepository;
import com.example.isa212.Services.IServices.IUserService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private ServiceForEmail serviceForEmail;

    @Override
    public User save(UserDTO userDTO) throws MessagingException, IOException, WriterException {
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

        user.setAccountEnabled(false);
        user.setAuthorities(authority);
        userRepository.save(user);
        serviceForEmail.emailForValidationAccount(user);
        return user;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User getUserByID(int ID) {
        return  userRepository.findOneById(ID);
    }

    @Override
    public void changeAccoundEnabledStatus(int user_id) {
        User user = getUserByID(user_id);
        if(user != null)
        {
            user.setAccountEnabled(true);
            userRepository.save(user);
        }

    }
}
