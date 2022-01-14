package com.example.isa212.Model.Users;

import com.example.isa212.Model.Boat;
import com.example.isa212.Model.Cottage;

import javax.persistence.*;
import java.util.HashSet;
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
}
