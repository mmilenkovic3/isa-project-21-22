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

    @Column
    private double grade;

    public Adventure() {
    }

    public Adventure(int id_adventure, String name, String address, String promoDescriptionAdventure, String bio, String capacity, List<Reservation> reservationsAdventure, List<FishingKit> fishingKits, List<Rules> rules, double price, CancellationType cancellationType, double grade) {
        this.id_adventure = id_adventure;
        this.name = name;
        this.address = address;
        this.promoDescriptionAdventure = promoDescriptionAdventure;
        this.bio = bio;
        this.capacity = capacity;
        this.reservationsAdventure = reservationsAdventure;
        this.fishingKits = fishingKits;
        this.rules = rules;
        this.price = price;
        this.cancellationType = cancellationType;
        this.grade = grade;
    }

    public int getId_adventure() {
        return id_adventure;
    }

    public void setId_adventure(int id_adventure) {
        this.id_adventure = id_adventure;
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

    public String getPromoDescriptionAdventure() {
        return promoDescriptionAdventure;
    }

    public void setPromoDescriptionAdventure(String promoDescriptionAdventure) {
        this.promoDescriptionAdventure = promoDescriptionAdventure;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public List<Reservation> getReservationsAdventure() {
        return reservationsAdventure;
    }

    public void setReservationsAdventure(List<Reservation> reservationsAdventure) {
        this.reservationsAdventure = reservationsAdventure;
    }

    public List<FishingKit> getFishingKits() {
        return fishingKits;
    }

    public void setFishingKits(List<FishingKit> fishingKits) {
        this.fishingKits = fishingKits;
    }

    public List<Rules> getRules() {
        return rules;
    }

    public void setRules(List<Rules> rules) {
        this.rules = rules;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CancellationType getCancellationType() {
        return cancellationType;
    }

    public void setCancellationType(CancellationType cancellationType) {
        this.cancellationType = cancellationType;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
