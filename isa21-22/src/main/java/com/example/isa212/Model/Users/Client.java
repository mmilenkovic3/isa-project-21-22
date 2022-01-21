package com.example.isa212.Model.Users;

import com.example.isa212.Model.*;
import com.example.isa212.Model.Enums.RoyalType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Client extends Users{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cottage_client_subscribes",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cottage_id", referencedColumnName = "id_cottage"))
    private Set<Cottage> cottageClientSubscribes = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "boat_client_subscribes",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "boat_id", referencedColumnName = "id_boat"))
    private Set<Boat> boatClientSubscribe = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "adventure_client_subscribes",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "adventure_id", referencedColumnName = "id_adventure"))
    private Set<Adventure> adventureClientSubscribe = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Reservation> reservations;

    @Column
    @Enumerated(EnumType.STRING)
    private RoyalType royalType;

    @Column
    private int penality;

    @Column
    private double points;

    public Client() {
    }

    public Client(String name, String surname, String email, String password, String address, String phoneNumber, String city, String country) {
        super(name, surname, email, password, address, phoneNumber, city, country);

    }

    public Set<Cottage> getCottageClientSubscribes() {
        return cottageClientSubscribes;
    }

    public void setCottageClientSubscribes(Set<Cottage> cottageClientSubscribes) {
        this.cottageClientSubscribes = cottageClientSubscribes;
    }

    public Set<Boat> getBoatClientSubscribe() {
        return boatClientSubscribe;
    }

    public void setBoatClientSubscribe(Set<Boat> boatClientSubscribe) {
        this.boatClientSubscribe = boatClientSubscribe;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Client(String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, Set<Cottage> cottageClientSubscribes, Set<Boat> boatClientSubscribe, Set<Adventure> adventureClientSubscribe, List<Reservation> reservations) {
        super(name, surname, email, password, address, phoneNumber, city, country);
        this.cottageClientSubscribes = cottageClientSubscribes;
        this.boatClientSubscribe = boatClientSubscribe;
        this.adventureClientSubscribe = adventureClientSubscribe;
        this.reservations = reservations;
    }

    public Client(String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, Set<Cottage> cottageClientSubscribes, Set<Boat> boatClientSubscribe, Set<Adventure> adventureClientSubscribe, List<Reservation> reservations, RoyalType royalType, int penality, double points) {
        super(name, surname, email, password, address, phoneNumber, city, country);
        this.cottageClientSubscribes = cottageClientSubscribes;
        this.boatClientSubscribe = boatClientSubscribe;
        this.adventureClientSubscribe = adventureClientSubscribe;
        this.reservations = reservations;
        this.royalType = royalType;
        this.penality = penality;
        this.points = points;
    }

    public Set<Adventure> getAdventureClientSubscribe() {
        return adventureClientSubscribe;
    }

    public void setAdventureClientSubscribe(Set<Adventure> adventureClientSubscribe) {
        this.adventureClientSubscribe = adventureClientSubscribe;
    }

    public RoyalType getRoyalType() {
        return royalType;
    }

    public void setRoyalType(RoyalType royalType) {
        this.royalType = royalType;
    }

    public int getPenality() {
        return penality;
    }

    public void setPenality(int penality) {
        this.penality = penality;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
