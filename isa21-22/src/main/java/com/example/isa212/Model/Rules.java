package com.example.isa212.Model;

import com.example.isa212.Model.Enums.ReservationType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Rules")
@Inheritance(strategy = InheritanceType.JOINED)
public class Rules {
    @Id
    @Column
    private int id_rules;
    @Column
    private String description;

    /*@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="rules_cottage",
            joinColumns = @JoinColumn(name ="rules_id", referencedColumnName = "id_rules"),
            inverseJoinColumns = @JoinColumn(name="cottage_id", referencedColumnName = "id_cottage"))
    private List<Cottage> cottagesRules;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="rules_boat",
            joinColumns = @JoinColumn(name ="rules_id", referencedColumnName = "id_rules"),
            inverseJoinColumns = @JoinColumn(name="boat_id", referencedColumnName = "id_boat"))
    private List<Boat> boatsRules;*/

    /*@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cottage", referencedColumnName = "id_cottage", nullable = true, unique = false)
    @JsonBackReference
    /*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPharm")
    @JsonIdentityReference(alwaysAsId = true)
    */
    //private Cottage cottage;
}
