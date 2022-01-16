package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Reservation;
import com.example.isa212.Repositories.ReservationRepository;
import com.example.isa212.Services.IServices.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    private ReservationRepository reservationRepository;


    @Override
    public Reservation findById_reservation(Integer id) {
        return reservationRepository.getOne(id);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
