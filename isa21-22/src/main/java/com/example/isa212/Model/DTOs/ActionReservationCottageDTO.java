package com.example.isa212.Model.DTOs;

import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.Enums.ReservationCancelType;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Model.Users.Actions;

public class ActionReservationCottageDTO {

    private Actions action;
    private Reservation reservation;
    private Cottage cottage;
    private ReservationCancelType reservationCancelType;

    public ActionReservationCottageDTO() {
    }

    public ActionReservationCottageDTO(Actions action, Reservation reservation, Cottage cottage) {
        this.action = action;
        this.reservation = reservation;
        this.cottage = cottage;
    }

    public ActionReservationCottageDTO(Actions action, Reservation reservation, Cottage cottage, ReservationCancelType reservationCancelType) {
        this.action = action;
        this.reservation = reservation;
        this.cottage = cottage;
        this.reservationCancelType = reservationCancelType;
    }

    public ReservationCancelType getReservationCancelType() {
        return reservationCancelType;
    }

    public void setReservationCancelType(ReservationCancelType reservationCancelType) {
        this.reservationCancelType = reservationCancelType;
    }

    public Cottage getCottage() {
        return cottage;
    }

    public void setCottage(Cottage cottage) {
        this.cottage = cottage;
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
