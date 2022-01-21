package com.example.isa212.Model.DTOs;

import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Model.Users.Actions;

public class ActionReservationCottageDTO {

    private Actions action;
    private Reservation reservation;
    private Cottage cottage;

    public ActionReservationCottageDTO() {
    }

    public ActionReservationCottageDTO(Actions action, Reservation reservation, Cottage cottage) {
        this.action = action;
        this.reservation = reservation;
        this.cottage = cottage;
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
