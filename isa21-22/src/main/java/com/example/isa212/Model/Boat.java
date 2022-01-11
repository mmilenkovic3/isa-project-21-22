package com.example.isa212.Model;


import com.example.isa212.Model.Enums.CancellationType;
import com.example.isa212.Model.Enums.NavigationEquipment;

import javax.persistence.*;
import java.awt.*;
import java.util.HashSet;
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
   /* @Column
    private Set<Image> images;
    @Column
    private Set<Reservation> reservations = new HashSet<>();
    @Column
    private int capacity;
    @Column
    private Set<Rules> rools = new HashSet<Rules>();
    //pecaroska oprema fali
    @Column
    private Set<Staff> boatStaff = new HashSet<Staff>();
    @Column
    private double price;*/

    @Column
    @Enumerated(EnumType.STRING)
    private CancellationType cancellationType;
}
