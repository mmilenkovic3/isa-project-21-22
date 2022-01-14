package com.example.isa212.Model;


import com.example.isa212.Model.Enums.CancellationType;
import com.example.isa212.Model.Enums.NavigationEquipment;

import javax.persistence.*;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Boat")
@Inheritance(strategy = InheritanceType.JOINED)
public class Boat {
    @Id
    @Column
    private int id_boat;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private double length;
    @Column
    private int engingeNum;
    @Column
    private int enginePower;
    @Column
    @Enumerated(EnumType.STRING)
    private NavigationEquipment navigationEquipment;
    @Column
    private String address;
    @Column
    private String promoDescriptionBoat;
    @Column
    private double maxSpeed;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rules> rules;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FishingKit> fishingKits;

   /* @Column
    private Set<Image> images;*/

    @Column
    private int capacity;
    @Column
    private double price;

    @Column
    @Enumerated(EnumType.STRING)
    private CancellationType cancellationType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="boat_reservation",
            joinColumns = @JoinColumn(name ="boat_id", referencedColumnName = "id_boat"),
            inverseJoinColumns = @JoinColumn(name="reservation_id", referencedColumnName = "id_reservation"))
    private List<Reservation> reservationsBoat;


    public Boat() {
    }
}
