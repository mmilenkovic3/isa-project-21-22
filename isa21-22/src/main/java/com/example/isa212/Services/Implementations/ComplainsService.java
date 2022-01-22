package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.*;
import com.example.isa212.Model.DTOs.ComplainsAdminDTO;
import com.example.isa212.Model.DTOs.ComplainsDTO;
import com.example.isa212.Model.Enums.ReservationType;
import com.example.isa212.Model.Users.Client;
import com.example.isa212.Repositories.ClientRepository;
import com.example.isa212.Repositories.ComplainsRepository;
import com.example.isa212.Services.IServices.IComplainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComplainsService implements IComplainsService {
    @Autowired
    private ComplainsRepository complainsRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CottageService cottageService;
    @Autowired
    private BoatService boatService;
    @Autowired
    private AdventureService adventureService;
    @Autowired ServiceForEmail serviceForEmail;

    public List<String> getNames(ReservationType reservationType, int id_client)
    {
        List<String> names = new ArrayList<String>();
        Client c = clientRepository.findById(id_client).get();
        if(reservationType.equals(ReservationType.COTTAGE))
        {
            List<Cottage> cottages = cottageService.findAll();
            for(Reservation reservation : c.getReservations())
            {
                if(reservation.getReservationType().equals(ReservationType.COTTAGE))
                {
                        for(Cottage cottage : cottages)
                        {
                            for(Reservation r : cottage.getReservations())
                            {
                                if(r.getId_reservation() == reservation.getId_reservation())
                                {
                                    if(disctinctNames(names, cottage.getName()))
                                        names.add(cottage.getName());
                                }
                            }
                        }
                }
            }
        }else if(reservationType.equals(ReservationType.BOAT))
        {
            List<Boat> boats = boatService.findAll();
            for(Reservation reservation : c.getReservations())
            {
                if(reservation.getReservationType().equals(ReservationType.BOAT))
                {
                    for(Boat bo : boats)
                    {
                        for(Reservation r : bo.getReservationsBoat())
                        {
                            if(r.getId_reservation() == reservation.getId_reservation())
                            {
                                if(disctinctNames(names, bo.getName()))
                                    names.add(bo.getName());
                            }
                        }
                    }
                }
            }

        }else if(reservationType.equals(ReservationType.ADVENTURE))
        {
            List<Adventure> adventures = adventureService.findAll();
            for(Reservation reservation : c.getReservations())
            {
                if(reservation.getReservationType().equals(ReservationType.ADVENTURE))
                {
                    for(Adventure adve : adventures)
                    {
                        for(Reservation r : adve.getReservationsAdventure())
                        {
                            if(r.getId_reservation() == reservation.getId_reservation())
                            {
                                if(disctinctNames(names, adve.getName()))
                                    names.add(adve.getName());
                            }
                        }
                    }
                }
            }
        }
        return names;

    }

    public boolean disctinctNames(List<String> names,String name)
    {
        for(String s : names)
        {
            if(s.equals(name)){
                return false;
            }
        }
        return  true;

    }

    public Complains saveComplain(ComplainsDTO complainsDTO) throws MessagingException {
        ReservationType reservationType = ReservationType.COTTAGE;
        if(complainsDTO.getEntityName().equals("BOAT"))
            reservationType = ReservationType.BOAT;
        else if(complainsDTO.getEntityName().equals("ADVENTURE"))
            reservationType = ReservationType.ADVENTURE;

        Client c = clientRepository.findById(complainsDTO.getId_client()).get();
        Complains complains = new Complains();
        complains.setClient(c);
        complains.setTextComplain(complainsDTO.getText());
        complains.setAnswered(false);
        complains.setReservationType(reservationType);
        complains.setName(complainsDTO.getName());
        complainsRepository.save(complains);
        serviceForEmail.sendComplainToAdmin(complains);

        return  complains;
    }

    public List<ComplainsAdminDTO> getAllComplains()
    {
        List<Complains> complains = complainsRepository.findAll();
        List<ComplainsAdminDTO> complainsAdminDTOS = new ArrayList<ComplainsAdminDTO>();
        for(Complains comp : complains)
        {
            ComplainsAdminDTO complainsAdminDTO = new ComplainsAdminDTO();
            complainsAdminDTO.setId_complain(comp.getId_complain());
            complainsAdminDTO.setClient_name(comp.getClient().getName() + " " + comp.getClient().getSurname());
            complainsAdminDTO.setTextComplain(comp.getTextComplain());
            complainsAdminDTO.setReservationType(comp.getReservationType());
            complainsAdminDTO.setEntityName(comp.getName());
            complainsAdminDTO.setAnswered(comp.isAnswered());
            complainsAdminDTO.setAnswer(comp.getAnswer());
            complainsAdminDTOS.add(complainsAdminDTO);
        }

        return complainsAdminDTOS;
    }

    public void setAnswer(int id_complain, String text) throws MessagingException {
        Complains complains = complainsRepository.findById(id_complain).get();
        complains.setAnswer(text);
        complains.setAnswered(true);
        complainsRepository.save(complains);

        ServiceForEmail.sendEmailToClientAboutAnswer(complains);
    }



}
