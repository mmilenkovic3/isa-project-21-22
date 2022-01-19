package com.example.isa212.Model.Users;


import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class BoatOwner extends Users {

    public BoatOwner() {
    }

    public BoatOwner(String name, String surname, String email, String password, String address, String phoneNumber, String city, String country) {
        super(name, surname, email, password, address, phoneNumber, city, country);
    }
}
