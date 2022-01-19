package com.example.isa212.Model.Users;

import javax.persistence.Entity;

@Entity
public class Admin extends Users{
    public Admin() {
    }

    public Admin(String name, String surname, String email, String password, String address, String phoneNumber, String city, String country) {
        super(name, surname, email, password, address, phoneNumber, city, country);
    }
}
