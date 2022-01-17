package com.example.isa212.Model.Users;

import com.example.isa212.Model.Adventure;
import com.example.isa212.Model.Reservation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Instructor extends Users{

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Adventure> adventures;

    public Instructor() {
    }

    public List<Adventure> getAdventures() {
        return adventures;
    }

    public void setAdventures(List<Adventure> adventures) {
        this.adventures = adventures;
    }
}
