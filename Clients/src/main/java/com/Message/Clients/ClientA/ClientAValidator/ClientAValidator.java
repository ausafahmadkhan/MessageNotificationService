package com.Message.Clients.ClientA.ClientAValidator;

import com.Message.Clients.ClientA.ClientARequest.ClientARequest;
import com.Message.Clients.ClientA.ClientAResponse.ClientAResponse;
import org.springframework.stereotype.Component;

@Component
public class ClientAValidator
{
    public boolean validateClientARequest(ClientARequest clientARequest)
    {
        if (clientARequest.getPhoneNumber() != null &&
            clientARequest.getPhoneNumber() != "" &&
            clientARequest.getMessageBody() != null &&
            clientARequest.getMessageBody() != "" &&
            clientARequest.getPhoneNumber().length() == 13)
            return true;
        throw new IllegalArgumentException();
    }
    public boolean validateClientAResponse(ClientAResponse clientAResponse)
    {
        if (clientAResponse.getSentStatus() != null &&
            clientAResponse.getSentStatus() != "")
            return true;
        throw new IllegalArgumentException();
    }
}
