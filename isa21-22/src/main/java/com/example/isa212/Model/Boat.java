package com.example.isa212.Model;


import com.example.isa212.Model.Enums.CancellationType;
import com.example.isa212.Model.Enums.NavigationEquipment;

import javax.persistence.*;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Boat")
@Inheritance(strategy = InheritanceType.JOINED)
public class Boat {
    @Id
    @Column
    private int id_boat;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private double length;
    @Column
    private int engingeNum;
    @Column
    private int enginePower;
    @Column
    @Enumerated(EnumType.STRING)
    private NavigationEquipment navigationEquipment;
    @Column
    private String address;
    @Column
    private String promoDescriptionBoat;
    @Column
    private double maxSpeed;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rules> rules;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="boat_fishing_kit",
            joinColumns = @JoinColumn(referencedColumnName = "id_boat"),
            inverseJoinColumns = @JoinColumn( referencedColumnName = "id_fishingKit"))

    private Set<FishingKit> fishingKits= new HashSet<FishingKit>();

   /* @Column
    private Set<Image> images;*/

    @Column
    private int capacity;
    @Column
    private double price;

    @Column
    @Enumerated(EnumType.STRING)
    private CancellationType cancellationType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="boat_reservation",
            joinColumns = @JoinColumn(name ="boat_id", referencedColumnName = "id_boat"),
            inverseJoinColumns = @JoinColumn(name="reservation_id", referencedColumnName = "id_reservation"))
    private List<Reservation> reservationsBoat;

    @Column
    private double grade;

    public Boat() {
    }

    public Set<FishingKit> getFishingKits() {
        return fishingKits;
    }

    public void setFishingKits(Set<FishingKit> fishingKits) {
        this.fishingKits = fishingKits;
    }

    public Boat(int id_boat, String name, String type, double length, int engingeNum, int enginePower, NavigationEquipment navigationEquipment, String address, String promoDescriptionBoat, double maxSpeed, List<Rules> rules, Set<FishingKit> fishingKits, int capacity, double price, CancellationType cancellationType, List<Reservation> reservationsBoat, double grade) {
        this.id_boat = id_boat;
        this.name = name;
        this.type = type;
        this.length = length;
        this.engingeNum = engingeNum;
        this.enginePower = enginePower;
        this.navigationEquipment = navigationEquipment;
        this.address = address;
        this.promoDescriptionBoat = promoDescriptionBoat;
        this.maxSpeed = maxSpeed;
        this.rules = rules;
        this.fishingKits = fishingKits;
        this.capacity = capacity;
        this.price = price;
        this.cancellationType = cancellationType;
        this.reservationsBoat = reservationsBoat;
        this.grade = grade;
    }

    public int getId_boat() {
        return id_boat;
    }

    public void setId_boat(int id_boat) {
        this.id_boat = id_boat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getEngingeNum() {
        return engingeNum;
    }

    public void setEngingeNum(int engingeNum) {
        this.engingeNum = engingeNum;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public NavigationEquipment getNavigationEquipment() {
        return navigationEquipment;
    }

    public void setNavigationEquipment(NavigationEquipment navigationEquipment) {
        this.navigationEquipment = navigationEquipment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPromoDescriptionBoat() {
        return promoDescriptionBoat;
    }

    public void setPromoDescriptionBoat(String promoDescriptionBoat) {
        this.promoDescriptionBoat = promoDescriptionBoat;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public List<Rules> getRules() {
        return rules;
    }

    public void setRules(List<Rules> rules) {
        this.rules = rules;
    }



    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    public List<Reservation> getReservationsBoat() {
        return reservationsBoat;
    }

    public void setReservationsBoat(List<Reservation> reservationsBoat) {
        this.reservationsBoat = reservationsBoat;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
