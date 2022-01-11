package com.example.isa212.Model;

import com.example.isa212.Model.Users.Authority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Staff")
@Inheritance(strategy = InheritanceType.JOINED)
public class Staff {

    @Id
    @Column
    private int id_staff;
    @Column
    private String name;

    public Staff() {
    }

    public int getId_staff() {
        return id_staff;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
