package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.ClientReservation;
import com.example.isa212.Model.Enums.ReservationCancelType;
import com.example.isa212.Model.Enums.ReservationStatus;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Repositories.ClientResetvationRepository;
import com.example.isa212.Repositories.ReservationRepository;
import com.example.isa212.Services.IServices.IClientReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientReservationService implements IClientReservationService {
    @Autowired
    private ClientResetvationRepository clientResetvationRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;

    public ClientReservation getReservationByID(int client_id, int reservation_id)
    {
        List<ClientReservation> clientReservationList = clientResetvationRepository.findAll();
        for(ClientReservation cr : clientReservationList)
        {
            if(cr.getReservation().getId_reservation() == reservation_id
                    && cr.getClient().getId() == client_id)
                return cr;
        }
        return null;

    }

    public ReservationCancelType getClientResType(int client_id, int reservation_id)
    {
        ClientReservation clientReservation = getReservationByID(client_id, reservation_id);
        return  clientReservation.getReservationCancelType();
    }

    public ClientReservation cancelReservation(int client_id,int reservation_id)
    {
        ClientReservation clientReservation = getReservationByID(client_id, reservation_id);
        clientReservation.getReservation().setReservationStatus(ReservationStatus.FREE);
        clientReservation.setReservationCancelType(ReservationCancelType.CANCELED);
        clientReservation.getReservation().setGrade(0);
        reservationService.save(clientReservation.getReservation());
        clientResetvationRepository.save(clientReservation);

        return  clientReservation;
    }

    public void setGradeToReservation(double grade, int id_reservation)
    {
        Reservation r = reservationRepository.findById(id_reservation).get();
        r.setGrade(grade);
        reservationRepository.save(r);
    }

    public void save(ClientReservation clientReservation) {
        clientResetvationRepository.save(clientReservation);
    }
}
