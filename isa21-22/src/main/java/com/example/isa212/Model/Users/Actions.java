package com.example.isa212.Model.Users;

import com.example.isa212.Model.Reservation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    @Column
    private int id_reservation;

    public Actions() {
    }

    public Actions(int id_action, LocalDate startDate, LocalDate endDate, double priceWithDiscount, double price, int id_reservation) {
        this.id_action = id_action;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceWithDiscount = priceWithDiscount;
        this.price = price;
        this.id_reservation = id_reservation;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
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


}
