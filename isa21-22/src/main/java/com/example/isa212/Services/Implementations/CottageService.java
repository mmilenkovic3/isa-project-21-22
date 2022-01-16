package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Boat;
import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.DTOs.ReservationParamsDTO;
import com.example.isa212.Model.Enums.ReservationCancelType;
import com.example.isa212.Model.Enums.ReservationFatsType;
import com.example.isa212.Model.Enums.ReservationStatus;
import com.example.isa212.Model.Enums.ReservationType;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Repositories.CottageRepository;
import com.example.isa212.Services.IServices.ICottageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class CottageService implements ICottageService {

    @Autowired
    private CottageRepository cottageRepository;

    @Override
    public List<Cottage> findAll() {
        return cottageRepository.findAll();
    }

    @Override
    public Cottage findOneById(int id) {
        return cottageRepository.getOne(id);
    }

    @Override
    public List<Cottage> sortByNameAsc(List<Cottage> cottages) {
        Collections.sort(cottages, (s1, s2) -> s1.getName().compareTo(s2.getName()) > 1 ? 1 : s1.getName().compareTo(s2.getName()) < 1 ? -1 : 0);
        return cottages;


    }

    @Override
    public List<Cottage> sortByNameDesc(List<Cottage> cottages) {
        Collections.sort(cottages, (s1, s2) -> s1.getName().compareTo(s2.getName()) < 1 ? 1 : s1.getName().compareTo(s2.getName()) > 1 ? -1 : 0);
        return cottages;
    }

    @Override
    public List<Cottage> sortByAddressAsc(List<Cottage> cottages) {
        Collections.sort(cottages, (s1, s2) -> s1.getAddress().compareTo(s2.getAddress()) > 1 ? 1 : s1.getAddress().compareTo(s2.getAddress()) < 1 ? -1 : 0);
        return cottages;
    }

    @Override
    public List<Cottage> sortByAddressDesc(List<Cottage> cottages) {
        Collections.sort(cottages, (s1, s2) -> s1.getAddress().compareTo(s2.getAddress()) < 1 ? 1 : s1.getAddress().compareTo(s2.getAddress()) > 1 ? -1 : 0);
        return cottages;
    }

    @Override
    public List<Cottage> sortByGradeAsc(List<Cottage> cottages) {
        //List<Cottage> cotagesGradeAsc = cottageRepository.findAll(Sort.by(Sort.Direction.ASC, "grade"));

        cottages.sort((o1, o2) -> Double.compare(o2.getGrade(), o1.getGrade()));
        return cottages;
    }

    @Override
    public List<Cottage> sortByGradeDesc(List<Cottage> cottages) {
        cottages.sort((o1, o2) -> Double.compare(o1.getGrade(), o2.getGrade()));
        return cottages;
    }

    @Override
    public List<Cottage> findAll(Sort sort) {
        return null;
    }

    public List<Cottage> getFreeReservationDate(ReservationParamsDTO reservationParamsDTO)
    {
        Time timeReservation = java.sql.Time.valueOf(reservationParamsDTO.getTime());


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateResrvation = formatter.format(reservationParamsDTO.getDate());



        List<Cottage> cottageFromFront = findAll();
        List<Cottage> searchCottage = new ArrayList<Cottage>();
        for (Cottage c: cottageFromFront) {
            for (Reservation res: c.getReservations()) {

                String dateFromListRes = formatter.format(res.getStartDate());

                if(dateFromListRes.equals(dateFromListRes)
                        && res.getStartTime().equals(timeReservation)
                        && res.getNumDays() == reservationParamsDTO.getNumDays()
                        && res.getReservationType().equals( ReservationType.COTTAGE)
                        && res.getReservationStatus().equals(ReservationStatus.FREE)
                        && res.getReservationCancelType().equals(ReservationCancelType.NOT_CANCEL)
                        && res.getReservationFastType().equals(ReservationFatsType.STANDARD))
                {
                    searchCottage.add(c);
                }
            }
        }

        List<Cottage> byAddress = new ArrayList<Cottage>();

        if(reservationParamsDTO.getAddress() != "")
        {
            for(Cottage cottage : searchCottage)
            {
                if(cottage.getAddress().contains(reservationParamsDTO.getAddress()))
                    byAddress.add(cottage);
            }
        }
        if(byAddress.size() != 0)
        {
            searchCottage.clear();
            searchCottage.addAll(byAddress);
        }


        List<Cottage> byGrade = new ArrayList<Cottage>();

        if(reservationParamsDTO.getGrade() != 0)
        {
            for(Cottage cottage : searchCottage)
            {
                if(cottage.getGrade() == reservationParamsDTO.getGrade())
                    byGrade.add(cottage);
            }
        }
        if(byGrade.size() != 0)
        {
            searchCottage.clear();
            searchCottage.addAll(byGrade);
        }

        return searchCottage;
    }






}
