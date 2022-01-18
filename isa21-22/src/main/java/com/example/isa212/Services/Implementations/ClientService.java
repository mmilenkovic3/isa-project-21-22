package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.DTOs.UserDTO;
import com.example.isa212.Model.Enums.ReservationStatus;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Model.Users.Client;
import com.example.isa212.Model.Users.Users;
import com.example.isa212.Repositories.ClientRepository;
import com.example.isa212.Repositories.CottageRepository;
import com.example.isa212.Services.IServices.IClientService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientService implements IClientService {

    @Autowired
    private CottageService cottageService;
    @Autowired
    private UserService userService;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private CottageRepository cottageRepository;



    @Override
    public Client subsribeOnCottage(int cottage_id, int user_id) {
        Optional<Cottage> cottage = cottageRepository.findById(cottage_id);

        Users user = userService.getUserByID(user_id);
        Client client = findById(user_id);

        Set<Cottage> subscribesCottage = client.getCottageClientSubscribes();
        for(Cottage c : subscribesCottage)
        {
            if(c.getId_cottage() == cottage_id)
                return null;
        }

        if( user!= null )
        {
            subscribesCottage.add(cottage.get());
            client.setCottageClientSubscribes(subscribesCottage);
        }

        save(client);
        return client;
    }

    @Override
    public Client findById(int id) {
        return clientRepository.getOne(id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void reserve(int client_id,  int reservation_id) {
        Client c = findById(client_id);
        Users user = userService.getUserByID(client_id);
        Reservation r = reservationService.findById_reservation(reservation_id);

        List<Reservation> clientReservationList = c.getReservations();
        clientReservationList.add(r);

        r.setReservationStatus(ReservationStatus.RESERVED);
        clientRepository.save(c);
        reservationService.save(r);

    }


    public Client unsubsribeOnCottage(int cottage_id, int user_id) {
        Cottage cottage = cottageService.findOneById(cottage_id);
        Users user = userService.getUserByID(user_id);
        Client client = findById(user_id);

        Set<Cottage> subscribesCottage = client.getCottageClientSubscribes();
        Set<Cottage> newList = new HashSet<Cottage>();
        newList.addAll( client.getCottageClientSubscribes());


        for(Cottage c : subscribesCottage)
        {
            if(c.getId_cottage() == cottage_id)
                newList.remove(c);
        }

        if( user!= null )
        {
            client.setCottageClientSubscribes(newList);
        }

        save(client);
        return client;

    }
}
