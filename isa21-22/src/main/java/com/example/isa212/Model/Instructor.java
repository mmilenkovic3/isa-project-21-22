package com.example.isa212.Model;

import com.example.isa212.Model.Enums.CancellationType;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Instructor {
    @Id
    @Column
    private int id_instructor;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String promoDescriptionBoat;
    @Column
    private String bio;
    @Column
    private String capacity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="instructor_reservation",
            joinColumns = @JoinColumn(name ="instructor_id", referencedColumnName = "id_instructor"),
            inverseJoinColumns = @JoinColumn(name="reservation_id", referencedColumnName = "id_reservation"))
    private List<Reservation> reservationsInstructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FishingKit> fishingKits;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rules> rules;

    @Column
    private double price;
    @Column
    @Enumerated(EnumType.STRING)
    private CancellationType cancellationType;
}
