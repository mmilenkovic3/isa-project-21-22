package com.example.isa212.Model.DTOs;

import com.example.isa212.Model.Adventure;
import com.example.isa212.Model.Enums.ReservationCancelType;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Model.Users.Actions;

public class ActionReservationAdventureDTO {

    private Actions action;
    private Reservation reservation;
    private Adventure adventure;
    private ReservationCancelType reservationCancelType;
    public ActionReservationAdventureDTO() {

    }

    public ActionReservationAdventureDTO(Actions action, Reservation reservation, Adventure adventure) {
        this.action = action;
        this.reservation = reservation;
        this.adventure = adventure;
    }

    public ActionReservationAdventureDTO(Actions action, Reservation reservation, Adventure adventure, ReservationCancelType reservationCancelType) {
        this.action = action;
        this.reservation = reservation;
        this.adventure = adventure;
        this.reservationCancelType = reservationCancelType;
    }

    public ReservationCancelType getReservationCancelType() {
        return reservationCancelType;
    }

    public void setReservationCancelType(ReservationCancelType reservationCancelType) {
        this.reservationCancelType = reservationCancelType;
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

    public Adventure getAdventure() {
        return adventure;
    }

    public void setAdventure(Adventure adventure) {
        this.adventure = adventure;
    }
}
