package com.example.isa212.Services.Implementations;

import com.example.isa212.Repositories.AdminRepository;
import com.example.isa212.Services.IServices.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private AdminRepository adminRepository;
}
