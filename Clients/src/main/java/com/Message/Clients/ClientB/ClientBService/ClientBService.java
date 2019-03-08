package com.Message.Clients.ClientB.ClientBService;

import com.Message.Clients.ClientB.ClientBRequest.ClientBRequest;
import com.Message.Clients.ClientB.ClientBResponse.ClientBResponse;
import com.Message.Clients.ClientB.ClientBValidator.ClientBValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ClientBService
{
    @Autowired
    private ClientBValidator clientBValidator;

    public ClientBResponse sendMessage(ClientBRequest clientBRequest)
    {
        clientBValidator.validateClientBRequest(clientBRequest);
        ClientBResponse clientBResponse = new ClientBResponse();
        //api call
        return clientBResponse;
    }
}
