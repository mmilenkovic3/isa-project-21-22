package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.DTOs.RegistrationApprovalDTO;
import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.RegistrationApproval;
import com.example.isa212.Model.Users.Admin;
import com.example.isa212.Model.Users.Authority;
import com.example.isa212.Model.Users.Users;
import com.example.isa212.Repositories.AdminRepository;
import com.example.isa212.Repositories.RegistrationApprovalRepository;
import com.example.isa212.Repositories.UserRepository;
import com.example.isa212.Services.IServices.IAdminService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
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
    @Autowired
    private RegistrationApprovalRepository registrationApprovalRepository;

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

    public  List<Users> getAllRequestUser()
    {
        List<Users> requests = new ArrayList<Users>();
        List<Users> allUsers = userRepository.findAll();
        for(Users u : allUsers)
        {
            if(!u.isApprovedByAdmin())
                requests.add(u);
        }
        return requests;
    }

    public void approveRequst(int userID) throws MessagingException {
        Users users = userRepository.findOneById(userID);
        users.setApprovedByAdmin(true);
        users.setAccountEnabled(true);
        userRepository.save(users);
        serviceForEmail.approvedEmail(users);

    }
    public void disapprove(int userID, String text) throws MessagingException {
        Users users = userRepository.findOneById(userID);
        serviceForEmail.disapproveEmail(users,text);
        userRepository.delete(users);

    }

    public List<RegistrationApprovalDTO> getRequestReg() {
        List<RegistrationApproval> registrationApprovals = registrationApprovalRepository.findAll();
        List<RegistrationApprovalDTO> re = new ArrayList<RegistrationApprovalDTO>();
        for(RegistrationApproval r : registrationApprovals)
        {
            RegistrationApprovalDTO registrationApprovalDTO = new RegistrationApprovalDTO();
            registrationApprovalDTO.setId(r.getId_registrationApproval());
            registrationApprovalDTO.setType(r.getAutority());
            Users u = userRepository.findOneById(r.getId_user());
            registrationApprovalDTO.setEmail(u.getEmail());
            registrationApprovalDTO.setUser_name(u.getName() + " " + u.getSurname());
            registrationApprovalDTO.setAprove(r.getApproved());

            re.add(registrationApprovalDTO);
        }

        return re;



    }
}
