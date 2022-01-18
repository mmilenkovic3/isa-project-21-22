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

@Service
public class BoatService implements IBoatService {
    @Autowired
    private BoatRepository boatRepository;

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
        Time timeReservation = java.sql.Time.valueOf(reservationParamsDTO.getTime());


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateResrvation = formatter.format(reservationParamsDTO.getDate());



        List<Boat> boatsFromFront = findAll();
        List<Boat> searchBoat = new ArrayList<Boat>();
        for (Boat boat: boatsFromFront) {
            for (Reservation res: boat.getReservationsBoat()) {

                String dateFromListRes = formatter.format(res.getStartDate());

                if(dateFromListRes.equals(dateFromListRes)
                        && res.getStartTime().equals(timeReservation)
                        && res.getNumDays() == reservationParamsDTO.getNumDays()
                        && res.getReservationType().equals( ReservationType.BOAT)
                        && res.getReservationStatus().equals(ReservationStatus.FREE)
                        && res.getReservationCancelType().equals(ReservationCancelType.NOT_CANCEL)
                        && res.getReservationFastType().equals(ReservationFatsType.STANDARD))
                {
                    searchBoat.add(boat);
                }
            }
        }

        List<Boat> byAddress = new ArrayList<Boat>();

        if(reservationParamsDTO.getAddress() != "")
        {
            for(Boat boat : searchBoat)
            {
                if(boat.getAddress().contains(reservationParamsDTO.getAddress()))
                    byAddress.add(boat);
            }
        }
        if(byAddress.size() != 0)
        {
            searchBoat.clear();
            searchBoat.addAll(byAddress);
        }


        List<Boat> byGrade = new ArrayList<Boat>();

        if(reservationParamsDTO.getGrade() != 0)
        {
            for(Boat boat : searchBoat)
            {
                if(boat.getGrade() == reservationParamsDTO.getGrade())
                    byGrade.add(boat);
            }
        }
        if(byGrade.size() != 0)
        {
            searchBoat.clear();
            searchBoat.addAll(byGrade);
        }

        return searchBoat;
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

}
