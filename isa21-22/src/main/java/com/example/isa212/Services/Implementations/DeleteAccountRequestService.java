package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.DTOs.DeleteReqDTO;
import com.example.isa212.Model.DeleteAccountRequest;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Model.Users.Client;
import com.example.isa212.Model.Users.Users;
import com.example.isa212.Repositories.ClientRepository;
import com.example.isa212.Repositories.DeleteAccountRequestRepository;
import com.example.isa212.Services.IServices.IDeleteAccountRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeleteAccountRequestService implements IDeleteAccountRequestService {
    @Autowired
    private DeleteAccountRequestRepository deleteAccountRequestRepository;
    @Autowired
    private  UserService userService;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public DeleteAccountRequest deleteAccountRequest(int id) {
        DeleteAccountRequest deleteAccountRequest = deleteAccountRequestRepository.findById(id).get();
        if(deleteAccountRequest != null)
        {
            Users user = userService.getUserByID(deleteAccountRequest.getClient().getId());
            user.getAuthorities().clear();
            userService.save(user);

            deleteAccountRequest.setApproved(true);
            deleteAccountRequestRepository.save(deleteAccountRequest);
        }

        return deleteAccountRequest;

    }

    public boolean SendRequestForDelete(int id_user, String text) throws MessagingException {
        Client client = clientRepository.findById(id_user).get();
        List<DeleteAccountRequest> deleteAccountRequestList = deleteAccountRequestRepository.findAll();

        for(DeleteAccountRequest deleteAccountRequest : deleteAccountRequestList)
        {
            if(deleteAccountRequest.getClient().getId() == client.getId())
                return false;

        }

        for(Reservation r : client.getReservations())
        {
            LocalDate reservationStartDate = r.getStartDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            if(reservationStartDate.isAfter(LocalDate.now()))
                return  false;

        }

        DeleteAccountRequest newDAC = new DeleteAccountRequest(client, text, false);

        deleteAccountRequestRepository.save(newDAC);
        ServiceForEmail.sentToAdmin(newDAC);
        return true;
    }

    public void approveDeleteAccount(int id_delete,String text) throws MessagingException {
        DeleteAccountRequest deleteAccountRequest = deleteAccountRequestRepository.findById(id_delete).get();
        deleteAccountRequest.setApproved(true);
        deleteAccountRequestRepository.save(deleteAccountRequest);
        clientRepository.delete(deleteAccountRequest.getClient());

        ServiceForEmail.SendEmailDeleteACC(deleteAccountRequest, text);
    }

    public void disapproveDeleteAccount(int id_delete,String text) throws MessagingException {
        DeleteAccountRequest deleteAccountRequest = deleteAccountRequestRepository.findById(id_delete).get();
        deleteAccountRequestRepository.delete(deleteAccountRequest);
        ServiceForEmail.SendEmailDeleteACC(deleteAccountRequest, text);
    }

    public List<DeleteReqDTO> getAllDeleteRA()
    {
        List<DeleteReqDTO> returntval = new ArrayList<DeleteReqDTO>();
        List<DeleteAccountRequest> list = deleteAccountRequestRepository.findAll();
        for(DeleteAccountRequest d : list)
        {
            DeleteReqDTO deleteReqDTO = new DeleteReqDTO();
            deleteReqDTO.setId_req( d.getId_accRequest());
            deleteReqDTO.setEmail(d.getClient().getEmail());
            deleteReqDTO.setText(d.getText());
            deleteReqDTO.setApproved(d.isApproved());
            returntval.add(deleteReqDTO);
        }
        return returntval;
    }
}
