package com.example.isa212.Model.DTOs;

import com.example.isa212.Model.Boat;
import com.example.isa212.Model.Enums.ReservationCancelType;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Model.Users.Actions;

public class ActionReservationBoatDTO {

    private Actions action;
    private Reservation reservation;
    private Boat boat;
    private ReservationCancelType reservationCancelType;

    public ActionReservationBoatDTO() {
    }

    public ActionReservationBoatDTO(Actions action, Reservation reservation, Boat boat) {
        this.action = action;
        this.reservation = reservation;
        this.boat = boat;
    }

    public ActionReservationBoatDTO(Actions action, Reservation reservation, Boat boat, ReservationCancelType reservationCancelType) {
        this.action = action;
        this.reservation = reservation;
        this.boat = boat;
        this.reservationCancelType = reservationCancelType;
    }

    public ReservationCancelType getReservationCancelType() {
        return reservationCancelType;
    }

    public void setReservationCancelType(ReservationCancelType reservationCancelType) {
        this.reservationCancelType = reservationCancelType;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Actions getAction() {
        return action;
    }

    public void setAction(Actions action) {
        this.action = action;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
