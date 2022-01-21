package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Enums.ReservationCancelType;
import com.example.isa212.Model.Enums.ReservationFatsType;
import com.example.isa212.Model.Enums.ReservationStatus;
import com.example.isa212.Model.Enums.ReservationType;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Repositories.ReservationRepository;
import com.example.isa212.Services.IServices.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Reservation> reservationStandardFree(ReservationType reservationType){

        List<Reservation> allReservations = reservationRepository.findAll();
        List<Reservation> returnList = new ArrayList<Reservation>();
        for(Reservation reservation : allReservations)
        {
            if(reservation.getReservationType().equals(reservationType)
            && reservation.getReservationFastType().equals(ReservationFatsType.STANDARD)
            && reservation.getReservationCancelType().equals(ReservationCancelType.NOT_CANCEL)
            && reservation.getReservationStatus().equals(ReservationStatus.FREE))
            {
                returnList.add(reservation);
            }
        }
        return returnList;
    }


   // public List<Reservation>




}
