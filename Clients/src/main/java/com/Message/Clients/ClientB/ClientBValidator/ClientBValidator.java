package com.Message.Clients.ClientB.ClientBValidator;

import com.Message.Clients.ClientB.ClientBResponse.ClientBResponse;
import com.Message.Clients.ClientB.ClientBRequest.ClientBRequest;
import org.springframework.stereotype.Component;

@Component
public class ClientBValidator
{
    public boolean validateClientBRequest(ClientBRequest clientBRequest)
    {
        if (clientBRequest.getPhoneNumber() != null &&
            clientBRequest.getPhoneNumber() != "" &&
            clientBRequest.getMessageBody() != null &&
            clientBRequest.getMessageBody() != "" &&
            clientBRequest.getPhoneNumber().length() == 13)
            return true;
        throw new IllegalArgumentException();
    }
    public boolean validateClientBResponse(ClientBResponse clientBResponse)
    {
        if (clientBResponse.getSentStatus() != null &&
            clientBResponse.getSentStatus() != "")
            return true;
        throw new IllegalArgumentException();
    }
}
