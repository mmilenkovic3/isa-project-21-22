package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Adventure;
import com.example.isa212.Model.Boat;
import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.DTOs.ActionReservationAdventureDTO;
import com.example.isa212.Model.DTOs.ActionReservationBoatDTO;
import com.example.isa212.Model.DTOs.ActionReservationCottageDTO;
import com.example.isa212.Model.Enums.ReservationFatsType;
import com.example.isa212.Model.Enums.ReservationStatus;
import com.example.isa212.Model.Enums.ReservationType;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Model.Users.Actions;
import com.example.isa212.Model.Users.Client;
import com.example.isa212.Repositories.ActionsRepository;
import com.example.isa212.Repositories.ClientRepository;
import com.example.isa212.Repositories.ReservationRepository;
import com.example.isa212.Services.IServices.IActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ActionsService implements IActionsService {

    @Autowired
    private ActionsRepository actionsRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CottageService cottageService;
    @Autowired
    private BoatService boatService;
    @Autowired
    private AdventureService adventureService;
    @Autowired
    private ClientRepository clientRepository;


    public List<ActionReservationCottageDTO> findAll(int client_id) {
        Client client = clientRepository.findById(client_id).get();
        Set<Cottage> subsribeCottages = client.getCottageClientSubscribes();

        List<ActionReservationCottageDTO> list = new ArrayList<ActionReservationCottageDTO>();

        for(Cottage cottage : subsribeCottages)
        {
            for(Reservation reservation : cottage.getReservations())
            {
                if(reservation.getReservationType().equals(ReservationType.COTTAGE)
                && reservation.getReservationStatus().equals(ReservationStatus.FREE)
                && reservation.getReservationFastType().equals(ReservationFatsType.ACTION))
                {
                    Actions actions = findByIDReservation(reservation.getId_reservation());
                    if(actions != null)
                    {
                        if(actions.getStartDate().isAfter(LocalDate.now()))
                        {
                            ActionReservationCottageDTO actionReservationCottageDTO = new ActionReservationCottageDTO();
                            actionReservationCottageDTO.setCottage(cottage);
                            actionReservationCottageDTO.setAction(actions);
                            actionReservationCottageDTO.setReservation(reservation);
                            if(checkIfExista(list,actionReservationCottageDTO ))
                            {
                                list.add(actionReservationCottageDTO);
                            }
                        }
                    }

                }
            }
        }
        return list;
    }

    private boolean checkIfExista(List<ActionReservationCottageDTO> list, ActionReservationCottageDTO actionReservationCottageDTO) {

        for(ActionReservationCottageDTO a : list)
        {
            if(a.getReservation().getId_reservation() == actionReservationCottageDTO.getReservation().getId_reservation())
                return false;
        }
        return  true;

    }


    public List<ActionReservationBoatDTO> findAllBoat(int client_id) {
        Client client = clientRepository.findById(client_id).get();
        Set<Boat> subscribeBoats = client.getBoatClientSubscribe();

        List<ActionReservationBoatDTO> list = new ArrayList<ActionReservationBoatDTO>();

        for(Boat boats : subscribeBoats)
        {
            for(Reservation reservation : boats.getReservationsBoat())
            {
                if(reservation.getReservationType().equals(ReservationType.BOAT)
                        && reservation.getReservationStatus().equals(ReservationStatus.FREE)
                        && reservation.getReservationFastType().equals(ReservationFatsType.ACTION))
                {
                    Actions actions = findByIDReservation(reservation.getId_reservation());
                    if(actions != null)
                    {


                        if(actions.getStartDate().isAfter(LocalDate.now()))
                        {
                            ActionReservationBoatDTO actionReservationBoatDTO = new ActionReservationBoatDTO();
                            actionReservationBoatDTO.setBoat(boats);
                            actionReservationBoatDTO.setAction(actions);
                            actionReservationBoatDTO.setReservation(reservation);
                            if(checkIfExtistBoat(list, actionReservationBoatDTO))
                                list.add(actionReservationBoatDTO);
                        }
                    }

                }
            }
        }
        return list;
    }

    private boolean checkIfExtistBoat(List<ActionReservationBoatDTO> list, ActionReservationBoatDTO actionReservationBoatDTO) {
        for(ActionReservationBoatDTO a : list)
        {
            if(a.getReservation().getId_reservation() == actionReservationBoatDTO.getReservation().getId_reservation())
                return false;
        }
        return  true;
    }

    private boolean checkIfExtistAdventure(List<ActionReservationAdventureDTO> list, ActionReservationAdventureDTO actionReservationADventureDTO) {
        for(ActionReservationAdventureDTO a : list)
        {
            if(a.getReservation().getId_reservation() == actionReservationADventureDTO.getReservation().getId_reservation())
                return false;
        }
        return  true;
    }

    public List<ActionReservationAdventureDTO> findAllAdventure(int client_id) {
        Client client = clientRepository.findById(client_id).get();
        Set<Adventure> subscribeAdventures = client.getAdventureClientSubscribe();

        List<ActionReservationAdventureDTO> list = new ArrayList<ActionReservationAdventureDTO>();

        for(Adventure adventure : subscribeAdventures)
        {
            for(Reservation reservation : adventure.getReservationsAdventure())
            {
                if(reservation.getReservationType().equals(ReservationType.ADVENTURE)
                        && reservation.getReservationStatus().equals(ReservationStatus.FREE)
                        && reservation.getReservationFastType().equals(ReservationFatsType.ACTION))
                {
                    Actions actions = findByIDReservation(reservation.getId_reservation());
                    if(actions != null)
                    {


                        if(actions.getStartDate().isAfter(LocalDate.now()))
                        {
                            ActionReservationAdventureDTO actionReservationAdventureDTODTO = new ActionReservationAdventureDTO();
                            actionReservationAdventureDTODTO.setAdventure(adventure);
                            actionReservationAdventureDTODTO.setAction(actions);
                            actionReservationAdventureDTODTO.setReservation(reservation);
                            if(checkIfExtistAdventure(list, actionReservationAdventureDTODTO))
                            list.add(actionReservationAdventureDTODTO);
                        }
                    }

                }
            }
        }
        return list;
    }





    public Actions findByIDReservation(int id_reservation)
    {
        List<Actions> actionsList = actionsRepository.findAll();
        for(Actions actions: actionsList)
        {
            if(actions.getId_reservation() == id_reservation)
                return actions;
        }
        return  null;

    }






}
