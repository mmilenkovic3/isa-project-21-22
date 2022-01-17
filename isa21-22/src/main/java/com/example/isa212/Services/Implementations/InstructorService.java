package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Users.Instructor;
import com.example.isa212.Repositories.InstructorRepository;
import com.example.isa212.Services.IServices.IInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService implements IInstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public Instructor save(Instructor instructor) {
        return  instructorRepository.save(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return instructorRepository.getOne(id);
    }
}
