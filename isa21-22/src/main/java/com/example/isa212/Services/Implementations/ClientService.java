package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Adventure;
import com.example.isa212.Model.Boat;
import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.Enums.ReservationStatus;
import com.example.isa212.Model.Enums.ReservationType;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Model.Users.Client;
import com.example.isa212.Model.Users.Users;
import com.example.isa212.Repositories.AdventureRepository;
import com.example.isa212.Repositories.BoatRepository;
import com.example.isa212.Repositories.ClientRepository;
import com.example.isa212.Repositories.CottageRepository;
import com.example.isa212.Services.IServices.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.*;

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
    @Autowired
    private AdventureRepository adventureRepository;
    @Autowired
    private BoatRepository boatRepository;

    @Autowired
    private ServiceForEmail serviceForEmail;



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



    public void reserve(int client_id,  int reservation_id) throws MessagingException {
        Client c = findById(client_id);
        Users user = userService.getUserByID(client_id);
        Reservation r = reservationService.findById_reservation(reservation_id);

        List<Reservation> clientReservationList = c.getReservations();
        clientReservationList.add(r);

        r.setReservationStatus(ReservationStatus.RESERVED);
        r.setDateWhenIsReserved(new Date());
        clientRepository.save(c);
        reservationService.save(r);


        if(r.getReservationType().equals(ReservationType.COTTAGE))
        {
            Cottage cottage = null;
            List<Cottage> cottages = cottageService.findAll();
            for(Cottage cot : cottages)
            {
                for (Reservation res : cot.getReservations())
                {
                    if(res.getId_reservation() == r.getId_reservation())
                    {
                        cottage = cot;
                        break;
                    }
                }
            }

            serviceForEmail.SendInformationAboutReservationCottage(user, r, cottage);

        }else if(r.getReservationType().equals(ReservationType.BOAT))
        {
            Boat b = null;
            List<Boat> boats = boatRepository.findAll();
            for(Boat boat : boats)
            {
                for (Reservation res : boat.getReservationsBoat())
                {
                    if(res.getId_reservation() == r.getId_reservation())
                    {
                        b = boat;
                        break;
                    }
                }
            }

            serviceForEmail.SendInformationAboutReservationBoat(user, r, b);
        }else
        {
            Adventure adventure = null;
            List<Adventure> adventures = adventureRepository.findAll();
            for(Adventure adve : adventures)
            {
                for (Reservation res : adve.getReservationsAdventure())
                {
                    if(res.getId_reservation() == r.getId_reservation())
                    {
                        adventure = adve;
                        break;
                    }
                }
            }

            serviceForEmail.SendInformationAboutReservationAdventure(user, r, adventure);
        }





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

    public Client subsribeOnBoat(int boat_id, int user_id) {
        Optional<Boat> boats = boatRepository.findById(boat_id);

        Users user = userService.getUserByID(user_id);
        Client client = findById(user_id);

        Set<Boat> subscribesBoat = client.getBoatClientSubscribe();
        for(Boat c : subscribesBoat)
        {
            if(c.getId_boat() == boat_id)
                return null;
        }

        if( user!= null )
        {
            subscribesBoat.add(boats.get());
            client.setBoatClientSubscribe(subscribesBoat);
        }

        save(client);
        return client;
    }

    public Client subsribeOnAdventure(int adventure_id, int user_id) {
        Optional<Adventure> adventure = adventureRepository.findById(adventure_id);

        Users user = userService.getUserByID(user_id);
        Client client = findById(user_id);

        Set<Adventure> subscribesAdventure = client.getAdventureClientSubscribe();
        for(Adventure c : subscribesAdventure)
        {
            if(c.getId_adventure() == adventure_id)
                return null;
        }

        if( user!= null )
        {
            subscribesAdventure.add(adventure.get());
            client.setAdventureClientSubscribe(subscribesAdventure);
        }

        save(client);
        return client;
    }



    public Client unsubsribeOnBoat(int boat_id, int user_id) {
        Optional<Boat> boat = boatRepository.findById(boat_id);
        Users user = userService.getUserByID(user_id);
        Client client = findById(user_id);

        Set<Boat> subscribesBoat = client.getBoatClientSubscribe();
        Set<Boat> newList = new HashSet<Boat>();
        newList.addAll( client.getBoatClientSubscribe());


        for(Boat c : subscribesBoat)
        {
            if(c.getId_boat() == boat_id)
                newList.remove(c);
        }

        if( user!= null )
        {
            client.setBoatClientSubscribe(newList);
        }

        save(client);
        return client;

    }

    public Client unsubsribeOnAdventure(int adventure_id, int user_id) {
        Optional<Adventure> adventure = adventureRepository.findById(adventure_id);
        Users user = userService.getUserByID(user_id);
        Client client = findById(user_id);

        Set<Adventure> subscribesAdventure = client.getAdventureClientSubscribe();
        Set<Adventure> newList = new HashSet<Adventure>();
        newList.addAll(client.getAdventureClientSubscribe());


        for(Adventure c : subscribesAdventure)
        {
            if(c.getId_adventure() == adventure_id)
                newList.remove(c);
        }

        if( user!= null )
        {
            client.setAdventureClientSubscribe(newList);
        }

        save(client);
        return client;

    }




}
