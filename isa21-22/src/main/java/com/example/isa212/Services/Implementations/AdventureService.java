package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Adventure;
import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.DTOs.ReservationParamsDTO;
import com.example.isa212.Model.Enums.ReservationCancelType;
import com.example.isa212.Model.Enums.ReservationFatsType;
import com.example.isa212.Model.Enums.ReservationStatus;
import com.example.isa212.Model.Enums.ReservationType;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Repositories.AdventureRepository;
import com.example.isa212.Services.IServices.IAdventureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AdventureService implements IAdventureService {
    @Autowired
    private AdventureRepository adventureRepository;

    @Override
    public List<Adventure> findAll() {
        return adventureRepository.findAll();
    }

    @Override
    public Adventure findOneById(int id) {
        return adventureRepository.getOne(id);
    }

    @Override
    public List<Adventure> sortByNameAsc(List<Adventure> adventures) {
        Collections.sort(adventures, (s1, s2) -> s1.getName().compareTo(s2.getName()) > 1 ? 1 : s1.getName().compareTo(s2.getName()) < 1 ? -1 : 0);
        return adventures;
    }

    @Override
    public List<Adventure> sortByNameDesc(List<Adventure> adventures) {
        Collections.sort(adventures, (s1, s2) -> s1.getName().compareTo(s2.getName()) < 1 ? 1 : s1.getName().compareTo(s2.getName()) > 1 ? -1 : 0);
        return adventures;
    }

    @Override
    public List<Adventure> sortByAddressAsc(List<Adventure> adventures) {
        Collections.sort(adventures, (s1, s2) -> s1.getAddress().compareTo(s2.getAddress()) > 1 ? 1 : s1.getAddress().compareTo(s2.getAddress()) < 1 ? -1 : 0);
        return adventures;
    }

    @Override
    public List<Adventure> sortByAddressDesc(List<Adventure> adventures) {
        Collections.sort(adventures, (s1, s2) -> s1.getAddress().compareTo(s2.getAddress()) < 1 ? 1 : s1.getAddress().compareTo(s2.getAddress()) > 1 ? -1 : 0);
        return adventures;
    }

    @Override
    public List<Adventure> sortByGradeAsc(List<Adventure> adventures) {
        adventures.sort((o1, o2) -> Double.compare(o2.getGrade(), o1.getGrade()));
        return adventures;
    }

    @Override
    public List<Adventure> sortByGradeDesc(List<Adventure> adventures) {
        adventures.sort((o1, o2) -> Double.compare(o1.getGrade(), o2.getGrade()));
        return adventures;
    }

    @Override
    public List<Adventure> findAll(Sort sort) {
        return adventureRepository.findAll();
    }

    public List<Adventure> getFreeReservationDate(ReservationParamsDTO reservationParamsDTO)
    {
        Time timeReservation = java.sql.Time.valueOf(reservationParamsDTO.getTime());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateResrvation = formatter.format(reservationParamsDTO.getDate());

        List<Adventure> adventureList = findAll();
        List<Adventure> searchAdventure = new ArrayList<Adventure>();
        for (Adventure a: adventureList) {
            for (Reservation res: a.getReservationsAdventure()) {

                String dateFromListRes = formatter.format(res.getStartDate());

                if(dateFromListRes.equals(dateFromListRes)
                        && res.getStartTime().equals(timeReservation)
                        && res.getNumDays() == reservationParamsDTO.getNumDays()
                        && res.getReservationType().equals( ReservationType.ADVENTURE)
                        && res.getReservationStatus().equals(ReservationStatus.FREE)
                        && res.getReservationCancelType().equals(ReservationCancelType.NOT_CANCEL)
                        && res.getReservationFastType().equals(ReservationFatsType.STANDARD))
                {
                    searchAdventure.add(a);
                }
            }
        }

        List<Adventure> byAddress = new ArrayList<Adventure>();

        if(reservationParamsDTO.getAddress() != "")
        {
            for(Adventure adventure : searchAdventure)
            {
                if(adventure.getAddress().contains(reservationParamsDTO.getAddress()))
                    byAddress.add(adventure);
            }
        }
        if(byAddress.size() != 0)
        {
            searchAdventure.clear();
            searchAdventure.addAll(byAddress);
        }


        List<Adventure> byGrade = new ArrayList<Adventure>();

        if(reservationParamsDTO.getGrade() != 0)
        {
            for(Adventure adventure : searchAdventure)
            {
                if(adventure.getGrade() == reservationParamsDTO.getGrade())
                    byGrade.add(adventure);
            }
        }
        if(byGrade.size() != 0)
        {
            searchAdventure.clear();
            searchAdventure.addAll(byGrade);
        }

        return searchAdventure;
    }


    public List<Adventure> freeReservationAdventureAction()
    {
        List<Adventure> adventures = findAll();
        List<Adventure> returnAdventure = new ArrayList<Adventure>();
        for(Adventure adventure : adventures)
        {
            for(Reservation reservation : adventure.getReservationsAdventure())
            {
                if(reservation.getReservationType().equals(ReservationType.ADVENTURE)
                        && reservation.getReservationStatus().equals(ReservationStatus.FREE)
                        && reservation.getReservationFastType().equals(ReservationFatsType.ACTION))
                {
                    returnAdventure.add(adventure);
                }
            }
        }

        return  returnAdventure;
    }
}
