package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.*;
import com.example.isa212.Model.DTOs.ActionReservationAdventureDTO;
import com.example.isa212.Model.DTOs.ActionReservationBoatDTO;
import com.example.isa212.Model.DTOs.ActionReservationCottageDTO;
import com.example.isa212.Model.DTOs.ClientAllReservationDTO;
import com.example.isa212.Model.Enums.ReservationCancelType;
import com.example.isa212.Model.Enums.ReservationFatsType;
import com.example.isa212.Model.Enums.ReservationStatus;
import com.example.isa212.Model.Enums.ReservationType;
import com.example.isa212.Model.Users.Actions;
import com.example.isa212.Model.Users.Client;
import com.example.isa212.Model.Users.Users;
import com.example.isa212.Repositories.*;
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
    @Autowired
    private ActionsService actionsService;
    @Autowired
    private ClientReservationService clientReservationService;



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



    public ClientAllReservationDTO findAllClientReservation(int id)
    {
        ClientAllReservationDTO clientAllReservation = new ClientAllReservationDTO();
        List<ActionReservationCottageDTO> actionReservationCottageDTOS = new ArrayList<ActionReservationCottageDTO>();
        List<ActionReservationBoatDTO> actionReservationBoatDTOS = new ArrayList<ActionReservationBoatDTO>();
        List<ActionReservationAdventureDTO> actionReservationAdventureDTOS = new ArrayList<ActionReservationAdventureDTO>();

        Client client = findById(id);
        for(Reservation reservation : client.getReservations())
        {
            if(reservation.getReservationType().equals(ReservationType.COTTAGE))
                actionReservationCottageDTOS.add(returnARCottageDTO(reservation));
            else if(reservation.getReservationType().equals(ReservationType.BOAT))
                actionReservationBoatDTOS.add(returnARBoatDTO(reservation));
            else if(reservation.getReservationType().equals(ReservationType.ADVENTURE))
               actionReservationAdventureDTOS.add(returnARAdventureDTO(reservation));

        }
        clientAllReservation.setActionReservationCottageDTOS(actionReservationCottageDTOS);
        clientAllReservation.setActionReservationBoatDTOS(actionReservationBoatDTOS);
        clientAllReservation.setActionReservationAdventureDTOS(actionReservationAdventureDTOS);
        return  clientAllReservation;
    }

    private ActionReservationAdventureDTO returnARAdventureDTO(Reservation reservation) {
        ActionReservationAdventureDTO actionReservationAdventureDTO = new ActionReservationAdventureDTO();
        List<Adventure> adventures = adventureRepository.findAll();
        for(Adventure adve : adventures)
        {
            for (Reservation res : adve.getReservationsAdventure())
            {
                if(res.getId_reservation() == reservation.getId_reservation())
                {
                    actionReservationAdventureDTO.setAdventure(adve);
                    actionReservationAdventureDTO.setReservation(res);
                    if(res.getReservationFastType().equals(ReservationFatsType.ACTION))
                    {
                        Actions action = actionsService.findByIDReservation(res.getId_reservation());
                        if(action != null)
                            actionReservationAdventureDTO.setAction(action);
                    }
                }
            }
        }

        return  actionReservationAdventureDTO;
    }

    private ActionReservationBoatDTO returnARBoatDTO(Reservation reservation) {

        ActionReservationBoatDTO actionReservationBoatDTO = new ActionReservationBoatDTO();
        List<Boat> boats = boatRepository.findAll();
        for(Boat boat : boats)
        {
            for (Reservation res : boat.getReservationsBoat())
            {
                if(res.getId_reservation() == reservation.getId_reservation())
                {
                    actionReservationBoatDTO.setBoat(boat);
                    actionReservationBoatDTO.setReservation(res);
                    if(res.getReservationFastType().equals(ReservationFatsType.ACTION))
                    {
                        Actions action = actionsService.findByIDReservation(res.getId_reservation());
                        if(action != null)
                            actionReservationBoatDTO.setAction(action);
                    }
                }
            }
        }

        return  actionReservationBoatDTO;
    }


    private ActionReservationCottageDTO returnARCottageDTO(Reservation reservation)
    {
        ActionReservationCottageDTO actionReservationCottageDTO = new ActionReservationCottageDTO();
        List<Cottage> cottages = cottageService.findAll();
        for(Cottage cottage : cottages)
        {
            for (Reservation res : cottage.getReservations())
            {
                if(res.getId_reservation() == reservation.getId_reservation())
                {
                    actionReservationCottageDTO.setCottage(cottage);
                    actionReservationCottageDTO.setReservation(res);
                    if(res.getReservationFastType().equals(ReservationFatsType.ACTION))
                    {
                        Actions action = actionsService.findByIDReservation(res.getId_reservation());
                        if(action != null)
                            actionReservationCottageDTO.setAction(action);

                    }

                    /*if(checkIfCottageReservationExists(actionReservationCottageDTOS, actionReservationCottageDTO))
                    {
                        actionReservationCottageDTOS.add(actionReservationCottageDTO);
                    }*/
                }
            }
        }

        return  actionReservationCottageDTO;
    }


    private boolean checkIfCottageReservationExists(List<ActionReservationCottageDTO> actionReservationCottageDTOS, ActionReservationCottageDTO actionReservationCottageDTO) {

        for(ActionReservationCottageDTO arCottage : actionReservationCottageDTOS)
        {
            if(arCottage.getReservation().getId_reservation() == actionReservationCottageDTO.getReservation().getId_reservation())
            {
                return  false;
            }
        }
        return true;
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
        ClientReservation clientReservation = new ClientReservation(c, r, ReservationCancelType.NOT_CANCEL);
        clientReservationService.save(clientReservation);

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
