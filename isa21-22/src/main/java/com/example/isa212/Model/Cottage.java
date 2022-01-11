package com.example.isa212.Model;


import javax.persistence.*;
import java.awt.*;
import java.util.List;


@Entity
@Table(name = "Cotagge")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cottage {

    @Id
    @Column(name = "id_cottage")
    private int id_cottage;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String promoDescription;

    //@Column
    //private ArrayList<Image> images;
    @Column
    private int numRoom;
    @Column
    private int numBed;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="cottage_reservation",
            joinColumns = @JoinColumn(name ="cottage_id", referencedColumnName = "id_cottage"),
            inverseJoinColumns = @JoinColumn(name="reservation_id", referencedColumnName = "id_reservation"))
    private List<Reservation> reservations;

    public Cottage() {


    }

    public Cottage(int id_cottage, String name, String address, String promoDescription, int numRoom, int numBed) {
        this.id_cottage = id_cottage;
        this.name = name;
        this.address = address;
        this.promoDescription = promoDescription;
        this.numRoom = numRoom;
        this.numBed = numBed;
    }
}
