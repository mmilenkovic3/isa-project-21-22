package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.Users.Client;
import com.example.isa212.Model.Users.Users;
import com.example.isa212.Repositories.ClientRepository;
import com.example.isa212.Services.IServices.IClientService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ClientService implements IClientService {

    @Autowired
    private CottageService cottageService;
    @Autowired
    private UserService userService;

    @Autowired
    private ClientRepository clientRepository;




    @Override
    public Client subsribeOnCottage(int cottage_id) {
        Cottage cottage = cottageService.findOneById(cottage_id);
        Users user = userService.getLoggedUser();
        Client client = findById(user.getId());

        Set<Cottage> subscribesCottage = client.getCottageClientSubscribes();
        for(Cottage c : subscribesCottage)
        {
            if(c.getId_cottage() == cottage_id)
                return null;
        }

        if( user!= null )
        {
            subscribesCottage.add(cottage);
            client.setCottageClientSubscribes(subscribesCottage);
        }
        return client;


    }

    @Override
    public Client findById(int id) {
        return clientRepository.getOne(id);
    }
}
