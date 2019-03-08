package com.Message.Clients.ClientC.ClientCService;

import com.Message.Clients.ClientC.ClientCRequest.ClientCRequest;
import com.Message.Clients.ClientC.ClientCResponse.ClientCResponse;
import com.Message.Clients.ClientC.ClientCValidator.ClientCValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ClientCService
{
    @Autowired
    private ClientCValidator clientCValidator;

    public ClientCResponse sendMessage(ClientCRequest clientCRequest)
    {
        clientCValidator.validateClientRequest(clientCRequest);
        ClientCResponse clientCResponse = new ClientCResponse();
        //api call
        return clientCResponse;
    }
}
