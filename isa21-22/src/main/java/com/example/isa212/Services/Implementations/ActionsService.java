package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Adventure;
import com.example.isa212.Model.Boat;
import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.DTOs.ActionReservationAdventureDTO;
import com.example.isa212.Model.DTOs.ActionReservationBoatDTO;
import com.example.isa212.Model.DTOs.ActionReservationCottageDTO;
import com.example.isa212.Model.Enums.ReservationStatus;
import com.example.isa212.Model.Enums.ReservationType;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Model.Users.Actions;
import com.example.isa212.Repositories.ActionsRepository;
import com.example.isa212.Repositories.ReservationRepository;
import com.example.isa212.Services.IServices.IActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ActionReservationCottageDTO> findAll() {
        List<Actions> actionsList = actionsRepository.findAll();
        List<Actions> newList = new ArrayList<Actions>();
        List<Cottage> cottages = cottageService.findAll();

        List<ActionReservationCottageDTO> actionReservationDTOS = new ArrayList<ActionReservationCottageDTO>();
        for(Actions actions : actionsList)
        {
            if(actions.getStartDate().isAfter(LocalDate.now())){

                ActionReservationCottageDTO actionReservationDTO = new ActionReservationCottageDTO();
                actionReservationDTO.setAction(actions);

                Reservation reservation = reservationRepository.findById(actions.getId_reservation()).get();
                actionReservationDTO.setReservation(reservation);

                for(Cottage c : cottages)
                {
                    Reservation r = c.getReservations().stream().filter(rr -> rr.getId_reservation() == reservation.getId_reservation()).findAny().orElse(null);
                    if(r!=null)
                    {
                        actionReservationDTO.setCottage(c);
                        break;
                    }
                }
                if(reservation.getReservationStatus().equals(ReservationStatus.FREE))
                    actionReservationDTOS.add(actionReservationDTO);
            }
        }
        return actionReservationDTOS;
    }

    public List<ActionReservationBoatDTO> findAllBoat() {
        List<Actions> actionsList = actionsRepository.findAll();
        List<Actions> newList = new ArrayList<Actions>();
        List<Boat> boats = boatService.findAll();

        List<ActionReservationBoatDTO> actionReservationDTOS = new ArrayList<ActionReservationBoatDTO>();
        for(Actions actions : actionsList)
        {
            if(actions.getStartDate().isAfter(LocalDate.now())){

                ActionReservationBoatDTO actionReservationDTO = new ActionReservationBoatDTO();
                actionReservationDTO.setAction(actions);

                Reservation reservation = reservationRepository.findById(actions.getId_reservation()).get();
               if(reservation.getReservationType().equals(ReservationType.BOAT)){
                   for(Boat c : boats)
                   {
                       Reservation r = c.getReservationsBoat().stream().filter(rr -> rr.getId_reservation() == reservation.getId_reservation()).findAny().orElse(null);
                       if(r!=null)
                       {
                           actionReservationDTO.setBoat(c);
                           break;
                       }
                   }
                   if(reservation.getReservationStatus().equals(ReservationStatus.FREE))
                       actionReservationDTOS.add(actionReservationDTO);
               }
                actionReservationDTO.setReservation(reservation);


            }
        }
        return actionReservationDTOS;
    }


    public List<ActionReservationAdventureDTO> findAllAdventure() {
        List<Actions> actionsList = actionsRepository.findAll();
        List<Actions> newList = new ArrayList<Actions>();
        List<Adventure> adventures = adventureService.findAll();

        List<ActionReservationAdventureDTO> actionReservationDTOS = new ArrayList<ActionReservationAdventureDTO>();
        for(Actions actions : actionsList)
        {
            if(actions.getStartDate().isAfter(LocalDate.now())){

                ActionReservationAdventureDTO actionReservationDTO = new ActionReservationAdventureDTO();
                actionReservationDTO.setAction(actions);

                Reservation reservation = reservationRepository.findById(actions.getId_reservation()).get();
                actionReservationDTO.setReservation(reservation);

                for(Adventure c : adventures)
                {
                    Reservation r = c.getReservationsAdventure().stream().filter(rr -> rr.getId_reservation() == reservation.getId_reservation()).findAny().orElse(null);
                    if(r!=null)
                    {
                        actionReservationDTO.setAdventure(c);
                        break;
                    }
                }
                if(reservation.getReservationStatus().equals(ReservationStatus.FREE))
                    actionReservationDTOS.add(actionReservationDTO);
            }
        }
        return actionReservationDTOS;
    }



}
