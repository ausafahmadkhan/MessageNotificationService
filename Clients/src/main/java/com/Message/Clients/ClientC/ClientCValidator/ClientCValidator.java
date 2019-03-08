package com.Message.Clients.ClientC.ClientCValidator;

import com.Message.Clients.ClientC.ClientCRequest.ClientCRequest;
import com.Message.Clients.ClientC.ClientCResponse.ClientCResponse;
import org.springframework.stereotype.Component;

@Component
public class ClientCValidator
{
    public boolean validateClientRequest(ClientCRequest clientCRequest)
    {
        if (clientCRequest.getPhoneNumber() != null &&
            clientCRequest.getPhoneNumber() != "" &&
            clientCRequest.getMessageBody() != null &&
            clientCRequest.getMessageBody() != "" &&
            clientCRequest.getPhoneNumber().length() == 13)
            return true;
        throw new IllegalArgumentException();
    }
    public boolean validateClientResponse(ClientCResponse clientCResponse)
    {
        if (clientCResponse.getSentStatus() != null &&
            clientCResponse.getSentStatus() != "")
            return true;
        throw new IllegalArgumentException();
    }
}
