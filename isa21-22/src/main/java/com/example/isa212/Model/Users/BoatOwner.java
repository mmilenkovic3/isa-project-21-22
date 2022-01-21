package com.example.isa212.Model.Users;


import com.example.isa212.Model.Boat;
import com.example.isa212.Model.Cottage;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class BoatOwner extends Users {

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Boat> boats;

    public BoatOwner() {
    }

    public BoatOwner(String name, String surname, String email, String password, String address, String phoneNumber, String city, String country) {
        super(name, surname, email, password, address, phoneNumber, city, country);
    }

    public BoatOwner(String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, List<Boat> boats) {
        super(name, surname, email, password, address, phoneNumber, city, country);
        this.boats = boats;
    }

    public List<Boat> getBoats() {
        return boats;
    }

    public void setBoats(List<Boat> boats) {
        this.boats = boats;
    }
}
