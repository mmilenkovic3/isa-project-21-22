package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Boat;
import com.example.isa212.Model.ClientReservation;
import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.DTOs.ReservationParamsDTO;
import com.example.isa212.Model.Enums.ReservationCancelType;
import com.example.isa212.Model.Enums.ReservationFatsType;
import com.example.isa212.Model.Enums.ReservationStatus;
import com.example.isa212.Model.Enums.ReservationType;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Repositories.ClientResetvationRepository;
import com.example.isa212.Repositories.CottageRepository;
import com.example.isa212.Repositories.ReservationRepository;
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
    @Autowired
    private ReservationService reservationService;

    @Override
    public List<Cottage> findAll() {
        return cottageRepository.findAll();
    }

    @Override
    public Cottage findOneById(int id) {
        return cottageRepository.findById(id).get();
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

    @Autowired
    private ClientReservationService clientReservationService;
    public List<Cottage> getFreeReservationDate(ReservationParamsDTO reservationParamsDTO) {
        List<Reservation> reservations = getReservationList(reservationParamsDTO, ReservationType.COTTAGE);


        List<Cottage> returnVal = new ArrayList<Cottage>();
        List<Cottage> cottages = findAll();
        for (Cottage c : cottages) {
            for (Reservation r : c.getReservations()) {
                Reservation res = reservations.stream().filter(rr -> rr.getId_reservation() == r.getId_reservation()).findAny().orElse(null);
                if (res != null) {
                    //proveriti da li je vec imao rezervisanu
                    ClientReservation cr = clientReservationService.getReservationByID( reservationParamsDTO.getId_client(), res.getId_reservation());
                    if(cr.getReservationCancelType().equals(ReservationCancelType.CANCELED))
                        returnVal.add(c);
                }

            }
        }

        List<Cottage> byAddress = new ArrayList<Cottage>();

        if (reservationParamsDTO.getAddress() != "") {
            for (Cottage cottage : returnVal) {
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



        List<Cottage> byGrade = new ArrayList<Cottage>();

        if (reservationParamsDTO.getGrade() != 0) {
            for (Cottage cottage : returnVal) {
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

    public List<Reservation> getReservationList(ReservationParamsDTO reservationParamsDTO, ReservationType reservationType) {
        Time timeReservation = Time.valueOf(reservationParamsDTO.getTime());


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateResrvation = formatter.format(reservationParamsDTO.getDate());


        List<Reservation> reservations = reservationService.reservationStandardFree(reservationType);
        List<Reservation> reservationsSearch = new ArrayList<Reservation>();
        if (!reservationParamsDTO.getDate().equals("")) {
            //Search by date
            for (Reservation res : reservations) {

                String dateFromListRes = formatter.format(res.getStartDate());
                if (dateResrvation.equals(dateFromListRes)) {
                    reservationsSearch.add(res);
                }
            }

            checkForList(reservations, reservationsSearch);

        }


        if (!reservationParamsDTO.getTime().equals("")) {
            //search by time
            for (Reservation res : reservations) {
                if (res.getStartTime().equals(timeReservation)) {
                    reservationsSearch.add(res);
                }
            }
            checkForList(reservations, reservationsSearch);


        }


        if (reservationParamsDTO.getNumDays() != 0) {
            //search by time
            for (Reservation res : reservations) {
                if (res.getNumDays() == reservationParamsDTO.getNumDays()) {
                    reservationsSearch.add(res);
                }
            }
            checkForList(reservations, reservationsSearch);

        }


        if (reservationParamsDTO.getNumPersons() != 0) {
            //search by time
            for (Reservation res : reservations) {
                if (res.getMaxPersons() == reservationParamsDTO.getNumPersons()) {
                    reservationsSearch.add(res);
                }
            }
            checkForList(reservations, reservationsSearch);

        }
        return reservations;
    }

    private void checkForList(List<Reservation> reservations, List<Reservation> reservationsSearch) {
        if(reservationsSearch.size() == 0)
        {
            reservations.clear();
        }
        else
        {
            reservations.clear();
            reservations.addAll(reservationsSearch);
            reservationsSearch.clear();

        }
    }


    private void emptyTheListSearch(List<Reservation> a, List<Reservation> b) {
        if(b.size() != 0)
        {
            a.clear();
            a.addAll(b);
            b.clear();
        }
    }

    public List<Cottage> freeReservationCottageAction()
    {



        List<Cottage> cottages = findAll();
        List<Cottage> returnCottages = new ArrayList<Cottage>();
        for(Cottage cottage : cottages)
        {
            for(Reservation reservation : cottage.getReservations())
            {
                if(reservation.getReservationType().equals(ReservationType.COTTAGE)
                && reservation.getReservationStatus().equals(ReservationStatus.FREE)
                && reservation.getReservationFastType().equals(ReservationFatsType.ACTION)
                && reservation.getReservationCancelType().equals(ReservationCancelType.NOT_CANCEL))
                {

                    returnCottages.add(cottage);
                }
            }
        }

        return  returnCottages;
    }


    public List<Cottage> searchByName(String name) {
        List<Cottage> cottages = findAll();
        List<Cottage> searhcByName = new ArrayList<Cottage>();
        for(Cottage c : cottages)
        {
            if(c.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)))
            {
                searhcByName.add(c);
            }
        }

        return searhcByName;
    }

    public List<Cottage> searchByAddress(String address) {
        List<Cottage> cottages = findAll();
        List<Cottage> searchByAddress = new ArrayList<Cottage>();
        for(Cottage c : cottages)
        {
            if(c.getAddress().toLowerCase(Locale.ROOT).contains(address.toLowerCase(Locale.ROOT)))
            {
                searchByAddress.add(c);
            }
        }

        return searchByAddress;
    }
}
