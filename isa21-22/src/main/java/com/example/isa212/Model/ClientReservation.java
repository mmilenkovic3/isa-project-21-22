package com.example.isa212.Model;

import com.example.isa212.Model.Enums.CancellationType;
import com.example.isa212.Model.Enums.ReservationCancelType;
import com.example.isa212.Model.Users.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Table(name="client_reservation_new")
@Entity
public class ClientReservation {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_clientReservation;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @JsonBackReference
    /*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPharm")
    @JsonIdentityReference(alwaysAsId = true)
    */
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reservation", referencedColumnName = "id_reservation")
    @JsonBackReference
    private Reservation reservation;

    @Column
    @Enumerated(EnumType.STRING)
    private ReservationCancelType reservationCancelType;

    public ClientReservation() {
    }

    public ClientReservation(int id_clientReservation, Client client, Reservation reservation, ReservationCancelType reservationCancelType) {
        this.id_clientReservation = id_clientReservation;
        this.client = client;
        this.reservation = reservation;
        this.reservationCancelType = reservationCancelType;
    }

    public ClientReservation(Client client, Reservation reservation, ReservationCancelType reservationCancelType) {
        this.client = client;
        this.reservation = reservation;
        this.reservationCancelType = reservationCancelType;
    }

    public int getId_clientReservation() {
        return id_clientReservation;
    }

    public void setId_clientReservation(int id_clientReservation) {
        this.id_clientReservation = id_clientReservation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public ReservationCancelType getReservationCancelType() {
        return reservationCancelType;
    }

    public void setReservationCancelType(ReservationCancelType reservationCancelType) {
        this.reservationCancelType = reservationCancelType;
    }
}
