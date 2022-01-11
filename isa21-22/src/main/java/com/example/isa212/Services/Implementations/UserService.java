package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.DTOs.PasswordDTO;
import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.UserTokenState;
import com.example.isa212.Model.Users.Authority;
import com.example.isa212.Model.Users.User;
import com.example.isa212.Repositories.UserRepository;
import com.example.isa212.Services.IServices.IUserService;
import com.example.isa212.Utils.TokenUtils;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


@Service
public class UserService implements IUserService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenUtils tokenUtils;

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
    Authentication authentication;

    @Override
    public UserTokenState Login(String email, String password) {

        authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getEmail());
        int expiresIn = tokenUtils.getExpiredIn();
        return new UserTokenState(jwt, expiresIn);
    }

    @Override
    public User getLoggedUser() {
        Authentication loggedUser = authentication; //SecurityContextHolder.getContext().getAuthentication();
        String email = loggedUser.getName();
        User u = userRepository.findByEmail(email);
        return  u;
    }

    @Override
    public User editUser(UserDTO userDTO) {
       User u = userRepository.findByEmail(userDTO.getEmail());

        u.setName(userDTO.getName());
        u.setSurname(userDTO.getSurname());
        u.setAddress(userDTO.getAddress());
        u.setPhoneNumber( userDTO.getPhoneNumber());
        u.setCity(userDTO.getCity());
        u.setCountry(userDTO.getCountry());


        userRepository.save(u);
        return u;
    }

    @Override
    public User changePassword(PasswordDTO passwordDTO) {
        User user = getLoggedUser();
        System.out.println(passwordEncoder.encode(passwordDTO.getPassword()));
        System.out.println("USER");
        System.out.println(user.getPassword());
        if(passwordEncoder.encode(passwordDTO.getPassword()) == user.getPassword())
            user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
        else
            return null;

        userRepository.save(user);
        return user;
    }
}
