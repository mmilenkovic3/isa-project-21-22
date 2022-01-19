package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.DeleteAccountRequest;
import com.example.isa212.Model.Users.Client;
import com.example.isa212.Model.Users.Users;
import com.example.isa212.Repositories.ClientRepository;
import com.example.isa212.Repositories.DeleteAccountRequestRepository;
import com.example.isa212.Services.IServices.IDeleteAccountRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean SendRequestForDelete(int id_user, String text)
    {
        Client client = clientRepository.findById(id_user).get();
        List<DeleteAccountRequest> deleteAccountRequestList = deleteAccountRequestRepository.findAll();

        for(DeleteAccountRequest deleteAccountRequest : deleteAccountRequestList)
        {
            if(deleteAccountRequest.getClient().getId() == client.getId())
                return false;

        }

        DeleteAccountRequest newDAC = new DeleteAccountRequest(client, text, true);

        deleteAccountRequestRepository.save(newDAC);
        return true;
    }
}
