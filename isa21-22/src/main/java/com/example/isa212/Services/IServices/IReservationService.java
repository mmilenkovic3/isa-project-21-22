package com.example.isa212.Services.IServices;

import com.example.isa212.Model.Reservation;

public interface IReservationService {
    public Reservation findById_reservation (Integer id);
    public Reservation save(Reservation reservation);
}
