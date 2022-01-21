package com.example.isa212.Services.IServices;

import com.example.isa212.Model.DTOs.ActionReservationCottageDTO;

import java.util.List;

public interface IActionsService {
    List<ActionReservationCottageDTO> findAll();
}
