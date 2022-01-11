package com.example.isa212.Model;

import javax.persistence.*;

@Entity
@Table(name = "Rules")
@Inheritance(strategy = InheritanceType.JOINED)
public class Rules {
    @Id
    @Column
    private int id_rules;
    @Column
    private String description;
}
