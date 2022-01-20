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
import java.util.Locale;

@Service
public class AdventureService implements IAdventureService {
    @Autowired
    private AdventureRepository adventureRepository;

    @Autowired
    private  CottageService cottageService;

    @Override
    public List<Adventure> findAll() {
        return adventureRepository.findAll();
    }

    @Override
    public Adventure findOneById(int id) {
        return adventureRepository.findById(id).get();
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
        List<Reservation> reservations = cottageService.getReservationList(reservationParamsDTO, ReservationType.ADVENTURE);


        List<Adventure> returnVal = new ArrayList<Adventure>();
        List<Adventure> adv = findAll();
        for (Adventure c : adv) {
            for (Reservation r : c.getReservationsAdventure()) {
                Reservation res = reservations.stream().filter(rr -> rr.getId_reservation() == r.getId_reservation()).findAny().orElse(null);
                if (res != null) {
                    returnVal.add(c);
                }

            }
        }

        List<Adventure> byAddress = new ArrayList<Adventure>();

        if (reservationParamsDTO.getAddress() != "") {
            for (Adventure cottage : returnVal) {
                if (cottage.getAddress().contains(reservationParamsDTO.getAddress()))
                    byAddress.add(cottage);
            }
            if (byAddress.size() != 0) {
                returnVal.clear();
                returnVal.addAll(byAddress);
            }else
            {
                returnVal.clear();
            }
        }



        List<Adventure> byGrade = new ArrayList<Adventure>();

        if (reservationParamsDTO.getGrade() != 0) {
            for (Adventure cottage : returnVal) {
                if (cottage.getGrade() == reservationParamsDTO.getGrade())
                    byGrade.add(cottage);
            }
            if (byGrade.size() != 0) {
                returnVal.clear();
                returnVal.addAll(byGrade);
            }
            else
            {
                returnVal.clear();
            }
        }


        return returnVal;
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

    public List<Adventure> searchByName(String name) {
        List<Adventure> adventures = findAll();
        List<Adventure> searhcByName = new ArrayList<Adventure>();
        for(Adventure c : adventures)
        {
            if(c.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)))
            {
                searhcByName.add(c);
            }
        }

        return searhcByName;
    }

    public List<Adventure> searchByAddress(String address) {
        List<Adventure> adventures = findAll();
        List<Adventure> searchByAddress = new ArrayList<Adventure>();
        for(Adventure c : adventures)
        {
            if(c.getAddress().toLowerCase(Locale.ROOT).contains(address.toLowerCase(Locale.ROOT)))
            {
                searchByAddress.add(c);
            }
        }

        return searchByAddress;
    }



}
