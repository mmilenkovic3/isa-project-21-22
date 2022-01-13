package com.example.isa212.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "Cotagge")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cottage  implements Serializable {

    @Id
    //@Column(name = "id_cottage")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_cottage;

    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String promoDescription;

    //@Column
    //private List<Image> images;
    @Column
    private int numRoom;
    @Column
    private int numBed;
    @Column
    private double grade;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="cottage_reservation",
            joinColumns = @JoinColumn(name ="cottage_id", referencedColumnName = "id_cottage"),
            inverseJoinColumns = @JoinColumn(name="reservation_id", referencedColumnName = "id_reservation"))
    private List<Reservation> reservations;



    @Column
    private double price;

    @Column
    private String info;

    public Cottage() {


    }

    public Cottage(int id_cottage, String name, String address, String promoDescription, int numRoom, int numBed, double grade, double price, String info) {
        this.id_cottage = id_cottage;
        this.name = name;
        this.address = address;
        this.promoDescription = promoDescription;
        this.numRoom = numRoom;
        this.numBed = numBed;
        this.grade = grade;
        this.price = price;
        this.info = info;
    }

    public int getId_cottage() {
        return id_cottage;
    }

    public void setId_cottage(int id_cottage) {
        this.id_cottage = id_cottage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPromoDescription() {
        return promoDescription;
    }

    public void setPromoDescription(String promoDescription) {
        this.promoDescription = promoDescription;
    }

    public int getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    public int getNumBed() {
        return numBed;
    }

    public void setNumBed(int numBed) {
        this.numBed = numBed;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
