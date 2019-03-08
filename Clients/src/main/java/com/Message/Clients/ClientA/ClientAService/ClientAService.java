package com.Message.Clients.ClientA.ClientAService;

import com.Message.Clients.ClientA.ClientARequest.ClientARequest;
import com.Message.Clients.ClientA.ClientAResponse.ClientAResponse;
import com.Message.Clients.ClientA.ClientAValidator.ClientAValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientAService
{
    @Autowired
    private ClientAValidator clientAValidator;

    public ClientAResponse sendMessage(ClientARequest clientARequest)
    {
        clientAValidator.validateClientARequest(clientARequest);
        ClientAResponse clientAResponse = new ClientAResponse();
        //api call
        return clientAResponse;
    }
}
