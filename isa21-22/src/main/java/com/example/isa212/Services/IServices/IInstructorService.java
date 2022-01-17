package com.example.isa212.Services.IServices;

import com.example.isa212.Model.Users.Instructor;

public interface IInstructorService {

    Instructor save(Instructor instructor);
    Instructor findById(int id);

}
