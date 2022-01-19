package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.Users.Admin;
import com.example.isa212.Model.Users.Authority;
import com.example.isa212.Model.Users.Users;
import com.example.isa212.Repositories.AdminRepository;
import com.example.isa212.Repositories.UserRepository;
import com.example.isa212.Services.IServices.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ServiceForEmail serviceForEmail;

    public Admin save(UserDTO userDTO) throws MessagingException {
        List<Authority> authority = authorityService.findByName("ROLE_ADMIN");

        for(Users u : userRepository.findAll()) {
            if(u.getEmail().equals(userDTO.getEmail()))
                return null;
        }

        String pass = "123";

        Admin user = new Admin(
                userDTO.getName(),
                userDTO.getSurname(),
                userDTO.getEmail(),
                passwordEncoder.encode(pass),
                userDTO.getAddress(),
                userDTO.getPhoneNumber(),
                userDTO.getCity(),
                userDTO.getCountry());


        user.setAccountEnabled(false);
        user.setAuthorities(authority);
        userRepository.save(user);
        //poslati na email
        serviceForEmail.SendLinkWithPassword(user, pass);
        return user;



    }
}
