package com.example.isa212.Repositories;

import com.example.isa212.Model.ClientReservation;
import com.example.isa212.Model.Enums.ReservationCancelType;
import com.example.isa212.Model.Enums.ReservationStatus;
import com.example.isa212.Services.Implementations.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientReservationService {
    @Autowired
    private ClientResetvationRepository clientResetvationRepository;

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

    public ReservationCancelType getReservationCancelType(int client_id, int reservation_id)
    {
        ClientReservation clientReservation = getReservationByID(client_id, reservation_id);
        return  clientReservation.getReservationCancelType();
    }

    public ClientReservation cancelReservation(int client_id,int reservation_id)
    {
        ClientReservation clientReservation = getReservationByID(client_id, reservation_id);
        clientReservation.getReservation().setReservationStatus(ReservationStatus.FREE);
        clientReservation.setReservationCancelType(ReservationCancelType.CANCELED);
        reservationService.save(clientReservation.getReservation());
        clientResetvationRepository.save(clientReservation);

        return  clientReservation;
    }

    public void save(ClientReservation clientReservation) {
        clientResetvationRepository.save(clientReservation);
    }
}
