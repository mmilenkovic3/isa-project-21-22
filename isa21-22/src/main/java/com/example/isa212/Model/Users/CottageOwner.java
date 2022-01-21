package com.example.isa212.Model.Users;

import com.example.isa212.Model.Adventure;
import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.Enums.RoyalType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class CottageOwner extends Users{


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cottage> cottages;

    public CottageOwner() {    }

    public CottageOwner(String name, String surname, String email, String password, String address, String phoneNumber, String city, String country) {
        super(name, surname, email, password, address, phoneNumber, city, country);
    }

    public CottageOwner(String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, List<Cottage> cottages) {
        super(name, surname, email, password, address, phoneNumber, city, country);
        this.cottages = cottages;
    }

    public List<Cottage> getCottages() {
        return cottages;
    }

    public void setCottages(List<Cottage> cottages) {
        this.cottages = cottages;
    }

}
