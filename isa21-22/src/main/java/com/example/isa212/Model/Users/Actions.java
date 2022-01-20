package com.example.isa212.Model.Users;

import com.example.isa212.Model.Reservation;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
public class Actions {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_action;

    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;

    @Column
    private double priceWithDiscount;
    @Column
    private double price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reservation", referencedColumnName = "id_reservation")
    private Reservation reservation;

    public Actions() {
    }

    public Actions(int id_action, LocalDate startDate, LocalDate endDate, double priceWithDiscount, double price, Reservation reservation) {
        this.id_action = id_action;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceWithDiscount = priceWithDiscount;
        this.price = price;
        this.reservation = reservation;
    }

    public int getId_action() {
        return id_action;
    }

    public void setId_action(int id_action) {
        this.id_action = id_action;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(double priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
