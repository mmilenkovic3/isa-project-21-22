package com.example.isa212.Model;

import com.example.isa212.Model.Enums.*;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Reservation")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reservation {
    @Id
    @Column
    private int id_reservation;
    @Column
    private Date startDate;

    @Column
    private Time startTime;
    @Column
    private int numDays;

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
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @Column
    @Enumerated(EnumType.STRING)
    private ReservationType reservationType;

    @Column
    @Enumerated(EnumType.STRING)
    private ReservationFatsType reservationFastType;

    @Column
    @Enumerated(EnumType.STRING)
    private ReservationCancelType reservationCancelType;

    @Column
    @Enumerated(EnumType.STRING)
    private CancellationType cancellationType;


    @Column
    private double grade;


    @Column(nullable = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dateWhenIsReserved;
    @Column(nullable = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double procent;

    @Column
    private double points;

    public Reservation(){}

    public Reservation(int id_reservation, Date startDate, Time startTime, int numDays, int maxPersons, List<Staff> staffs, double price, ReservationStatus reservationStatus, ReservationType reservationType, ReservationFatsType reservationFastType, ReservationCancelType reservationCancelType, CancellationType cancellationType) {
        this.id_reservation = id_reservation;
        this.startDate = startDate;
        this.startTime = startTime;
        this.numDays = numDays;
        this.maxPersons = maxPersons;
        this.staffs = staffs;
        this.price = price;
        this.reservationStatus = reservationStatus;
        this.reservationType = reservationType;
        this.reservationFastType = reservationFastType;
        this.reservationCancelType = reservationCancelType;
        this.cancellationType = cancellationType;
    }

    public Reservation(int id_reservation, Date startDate, Time startTime, int numDays, int maxPersons, List<Staff> staffs, double price, ReservationStatus reservationStatus, ReservationType reservationType, ReservationFatsType reservationFastType, ReservationCancelType reservationCancelType, CancellationType cancellationType, double grade, Date dateWhenIsReserved, double procent) {
        this.id_reservation = id_reservation;
        this.startDate = startDate;
        this.startTime = startTime;
        this.numDays = numDays;
        this.maxPersons = maxPersons;
        this.staffs = staffs;
        this.price = price;
        this.reservationStatus = reservationStatus;
        this.reservationType = reservationType;
        this.reservationFastType = reservationFastType;
        this.reservationCancelType = reservationCancelType;
        this.cancellationType = cancellationType;
        this.grade = grade;
        this.dateWhenIsReserved = dateWhenIsReserved;
        this.procent = procent;
    }

    public Date getDateWhenIsReserved() {
        return dateWhenIsReserved;
    }

    public void setDateWhenIsReserved(Date dateWhenIsReserved) {
        this.dateWhenIsReserved = dateWhenIsReserved;
    }

    public double getProcent() {
        return procent;
    }

    public void setProcent(double procent) {
        if(procent != 0)
            this.procent = procent;
        else
            this.procent = 0;
    }

    public Reservation(int id_reservation, Date startDate, Time startTime, int numDays, int maxPersons, List<Staff> staffs, double price, ReservationStatus reservationStatus, ReservationType reservationType, ReservationFatsType reservationFastType, ReservationCancelType reservationCancelType, CancellationType cancellationType, double grade) {
        this.id_reservation = id_reservation;
        this.startDate = startDate;
        this.startTime = startTime;
        this.numDays = numDays;
        this.maxPersons = maxPersons;
        this.staffs = staffs;
        this.price = price;
        this.reservationStatus = reservationStatus;
        this.reservationType = reservationType;
        this.reservationFastType = reservationFastType;
        this.reservationCancelType = reservationCancelType;
        this.cancellationType = cancellationType;
        this.grade = grade;
    }

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

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getNumDays() {
        return numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }

    public int getMaxPersons() {
        return maxPersons;
    }

    public void setMaxPersons(int maxPersons) {
        this.maxPersons = maxPersons;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public ReservationFatsType getReservationFastType() {
        return reservationFastType;
    }

    public void setReservationFastType(ReservationFatsType reservationFastType) {
        this.reservationFastType = reservationFastType;
    }

    public ReservationCancelType getReservationCancelType() {
        return reservationCancelType;
    }

    public void setReservationCancelType(ReservationCancelType reservationCancelType) {
        this.reservationCancelType = reservationCancelType;
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
