package com.example.isa212.Model;

import com.example.isa212.Model.Enums.ReservationStatus;
import com.example.isa212.Model.Users.Authority;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Reservation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Reservation {
    @Id
    @Column
    private int id_reservation;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private Time startTime;
    @Column
    private int maxPersons;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="reservation_stuff",
            joinColumns = @JoinColumn(name ="reservation_id", referencedColumnName = "id_reservation"),
            inverseJoinColumns = @JoinColumn(name="staff_id", referencedColumnName = "id_staff"))
    private List<Staff> staffs;


    @Column
    private double price;
    @Column
    private ReservationStatus reservationStatus;

    @Column
    private ReservationType reservationType;

    public Reservation(){}



    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getMaxPersons() {
        return maxPersons;
    }

    public void setMaxPersons(int maxPersons) {
        this.maxPersons = maxPersons;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
