package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Boat;
import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.DTOs.ReservationParamsDTO;
import com.example.isa212.Model.Enums.ReservationCancelType;
import com.example.isa212.Model.Enums.ReservationFatsType;
import com.example.isa212.Model.Enums.ReservationStatus;
import com.example.isa212.Model.Enums.ReservationType;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Repositories.BoatRepository;
import com.example.isa212.Services.IServices.IBoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Service
public class BoatService implements IBoatService {
    @Autowired
    private BoatRepository boatRepository;
    @Autowired
    private CottageService cottageService;
    @Override
    public List<Boat> findAll() {
        return  boatRepository.findAll();

    }

    @Override
    public Boat findOneById(int id) {
        return boatRepository.findById(id).get();
    }

    @Override
    public List<Boat> sortByNameAsc(List<Boat> boats) {
        Collections.sort(boats, (s1, s2) -> s1.getName().compareTo(s2.getName()) > 1 ? 1 : s1.getName().compareTo(s2.getName()) < 1 ? -1 : 0);
        return boats;
    }

    @Override
    public List<Boat> sortByNameDesc(List<Boat> boats) {
        Collections.sort(boats, (s1, s2) -> s1.getName().compareTo(s2.getName()) < 1 ? 1 : s1.getName().compareTo(s2.getName()) > 1 ? -1 : 0);
        return boats;
    }

    @Override
    public List<Boat> sortByAddressAsc(List<Boat> boats) {
        Collections.sort(boats, (s1, s2) -> s1.getAddress().compareTo(s2.getAddress()) > 1 ? 1 : s1.getAddress().compareTo(s2.getAddress()) < 1 ? -1 : 0);
        return boats;
    }

    @Override
    public List<Boat> sortByAddressDesc(List<Boat> boats) {
        Collections.sort(boats, (s1, s2) -> s1.getAddress().compareTo(s2.getAddress()) < 1 ? 1 : s1.getAddress().compareTo(s2.getAddress()) > 1 ? -1 : 0);
        return boats;
    }

    @Override
    public List<Boat> sortByGradeAsc(List<Boat> boats) {
        boats.sort((o1, o2) -> Double.compare(o2.getGrade(), o1.getGrade()));
        return boats;
    }

    @Override
    public List<Boat> sortByGradeDesc(List<Boat> boats) {
        boats.sort((o1, o2) -> Double.compare(o1.getGrade(), o2.getGrade()));
        return boats;
    }

    //Boat list of free reservation
    public List<Boat> getFreeBoatReservation(ReservationParamsDTO reservationParamsDTO)
    {
        List<Reservation> reservations = cottageService.getReservationList(reservationParamsDTO, ReservationType.BOAT);


        List<Boat> returnVal = new ArrayList<Boat>();
        List<Boat> boats = findAll();
        for (Boat c : boats) {
            for (Reservation r : c.getReservationsBoat()) {
                Reservation res = reservations.stream().filter(rr -> rr.getId_reservation() == r.getId_reservation()).findAny().orElse(null);
                if (res != null) {
                    returnVal.add(c);
                }

            }
        }

        List<Boat> byAddress = new ArrayList<Boat>();

        if (reservationParamsDTO.getAddress() != "") {
            for (Boat b : returnVal) {
                if (b.getAddress().contains(reservationParamsDTO.getAddress()))
                    byAddress.add(b);
            }
            if (byAddress.size() != 0) {
                returnVal.clear();
                returnVal.addAll(byAddress);
            }else
            {
                returnVal.clear();
            }
        }



        List<Boat> byGrade = new ArrayList<Boat>();

        if (reservationParamsDTO.getGrade() != 0) {
            for (Boat bb : returnVal) {
                if (bb.getGrade() == reservationParamsDTO.getGrade())
                    byGrade.add(bb);
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

    public List<Boat> freeReservationBoatAction()
    {
        List<Boat> boats = findAll();
        List<Boat> returnBoat = new ArrayList<Boat>();
        for(Boat r : boats)
        {
            for(Reservation reservation : r.getReservationsBoat())
            {
                if(reservation.getReservationType().equals(ReservationType.BOAT)
                        && reservation.getReservationStatus().equals(ReservationStatus.FREE)
                        && reservation.getReservationFastType().equals(ReservationFatsType.ACTION))
                {
                    returnBoat.add(r);
                }
            }
        }

        return  returnBoat;
    }

    public List<Boat> searchByName(String name) {
        List<Boat> boats = findAll();
        List<Boat> searhcByName = new ArrayList<Boat>();
        for(Boat c : boats)
        {
            if(c.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)))
            {
                searhcByName.add(c);
            }
        }

        return searhcByName;
    }

    public List<Boat> searchByAddress(String address) {
        List<Boat> boats = findAll();
        List<Boat> searchByAddress = new ArrayList<Boat>();
        for(Boat c : boats)
        {
            if(c.getAddress().toLowerCase(Locale.ROOT).contains(address.toLowerCase(Locale.ROOT)))
            {
                searchByAddress.add(c);
            }
        }

        return searchByAddress;
    }

}
