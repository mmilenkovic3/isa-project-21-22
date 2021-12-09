package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Users.Authority;
import com.example.isa212.Repositories.AuthorityRepository;
import com.example.isa212.Services.IServices.IAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityService implements IAuthorityService
{
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public List<Authority> findById(Integer id) {
        Authority auth = this.authorityRepository.getOne(id);
        List<Authority> auths = new ArrayList<>();
        auths.add(auth);
        return auths;
    }

    @Override
    public List<Authority> findByName(String name) {
        Authority authority = this.authorityRepository.findByName(name);
        List<Authority> authorityList = new ArrayList<>();
        authorityList.add(authority);
        return  authorityList;
    }

}
