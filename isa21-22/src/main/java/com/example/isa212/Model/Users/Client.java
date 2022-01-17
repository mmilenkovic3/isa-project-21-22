package com.example.isa212.Model.Users;

import com.example.isa212.Model.Boat;
import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Model.Rules;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    /*@Column
    private int penality;*/

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

    public Client(Integer id, String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, Set<Cottage> cottageClientSubscribes, Set<Boat> boatClientSubscribe, List<Reservation> reservations) {
        super(id, name, surname, email, password, address, phoneNumber, city, country);
        this.cottageClientSubscribes = cottageClientSubscribes;
        this.boatClientSubscribe = boatClientSubscribe;
        this.reservations = reservations;
    }
}
