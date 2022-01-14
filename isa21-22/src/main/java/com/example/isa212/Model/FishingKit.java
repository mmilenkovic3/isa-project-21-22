package com.example.isa212.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class FishingKit {

    @Id
    @Column
    private int id_fishingKit;
    @Column
    private String name;
}
