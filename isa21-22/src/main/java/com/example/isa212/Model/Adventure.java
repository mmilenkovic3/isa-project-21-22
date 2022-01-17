package com.example.isa212.Model;

import com.example.isa212.Model.Enums.CancellationType;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Adventure {
    @Id
    @Column
    private int id_adventure;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String promoDescriptionAdventure;
    @Column
    private String bio;

    /*
        SLIKE?
    */

    @Column
    private String capacity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="adventure_reservation",
            joinColumns = @JoinColumn(name ="adventure_id", referencedColumnName = "id_adventure"),
            inverseJoinColumns = @JoinColumn(name="reservation_id", referencedColumnName = "id_reservation"))
    private List<Reservation> reservationsAdventure;

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
