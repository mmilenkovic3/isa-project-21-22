package com.example.isa212.Model.DTOs;

import com.example.isa212.Model.Reservation;

import java.util.List;

public class ClientAllReservationDTO {
    private List<ActionReservationCottageDTO> actionReservationCottageDTOS;
    private List<ActionReservationBoatDTO> actionReservationBoatDTOS;
    private List<ActionReservationAdventureDTO> actionReservationAdventureDTOS;

    public ClientAllReservationDTO() {
    }

    public ClientAllReservationDTO(List<ActionReservationCottageDTO> actionReservationCottageDTOS, List<ActionReservationBoatDTO> actionReservationBoatDTOS, List<ActionReservationAdventureDTO> actionReservationAdventureDTOS) {
        this.actionReservationCottageDTOS = actionReservationCottageDTOS;
        this.actionReservationBoatDTOS = actionReservationBoatDTOS;
        this.actionReservationAdventureDTOS = actionReservationAdventureDTOS;
    }

    public List<ActionReservationCottageDTO> getActionReservationCottageDTOS() {
        return actionReservationCottageDTOS;
    }

    public void setActionReservationCottageDTOS(List<ActionReservationCottageDTO> actionReservationCottageDTOS) {
        this.actionReservationCottageDTOS = actionReservationCottageDTOS;
    }

    public List<ActionReservationBoatDTO> getActionReservationBoatDTOS() {
        return actionReservationBoatDTOS;
    }

    public void setActionReservationBoatDTOS(List<ActionReservationBoatDTO> actionReservationBoatDTOS) {
        this.actionReservationBoatDTOS = actionReservationBoatDTOS;
    }

    public List<ActionReservationAdventureDTO> getActionReservationAdventureDTOS() {
        return actionReservationAdventureDTOS;
    }

    public void setActionReservationAdventureDTOS(List<ActionReservationAdventureDTO> actionReservationAdventureDTOS) {
        this.actionReservationAdventureDTOS = actionReservationAdventureDTOS;
    }
}
