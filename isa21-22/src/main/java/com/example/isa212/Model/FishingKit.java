package com.example.isa212.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class FishingKit {

    @Id
    @Column
    private int id_fishingKit;
    @Column
    private String name;

    public FishingKit() {
    }

    public FishingKit(int id_fishingKit, String name) {
        this.id_fishingKit = id_fishingKit;
        this.name = name;
    }


    public int getId_fishingKit() {
        return id_fishingKit;
    }

    public void setId_fishingKit(int id_fishingKit) {
        this.id_fishingKit = id_fishingKit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
