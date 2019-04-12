package com.Message.App.Validator;

import com.Message.App.InternalContracts.MessageServiceClientA.MessageServiceClientAResponse;
import com.Message.App.InternalContracts.MessageServiceClientB.MessageServiceClientBResponse;
import com.Message.App.InternalContracts.MessageServiceClientC.MessageServiceClientCResponse;
import com.Message.App.MessageServiceDTOS.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTOS.MessageServiceResponseDTO;
import com.Message.Contracts.MessageRequest.MessageRequest;
import com.Message.Contracts.MessageResponse.MessageResponse;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceValidator
{
    public boolean validateMessageRequest(MessageRequest messageRequest)
    {
        if (messageRequest.getPhoneNumber() != null &&
            messageRequest.getPhoneNumber() != "" &&
            messageRequest.getMessageBody() != null &&
            messageRequest.getMessageBody() != "" &&
            messageRequest.getPhoneNumber().length() == 13)
            return true;
        throw new IllegalArgumentException();
    }

    public boolean validateMessageResponse(MessageResponse messageResponse)
    {
        if (messageResponse.getSentStatus() != null &&
            messageResponse.getSentStatus() != "")
            return true;
        throw new IllegalArgumentException();
    }

    public boolean validateClientAResponse(MessageServiceClientAResponse messageServiceClientAResponse)
    {
        if (messageServiceClientAResponse.getSentStatus() != null &&
                messageServiceClientAResponse.getSentStatus() != "")
            return true;
        throw new IllegalArgumentException();
    }

    public boolean validateClientBResponse(MessageServiceClientBResponse messageServiceClientBResponse)
    {
        if (messageServiceClientBResponse.getSentStatus() != null &&
                messageServiceClientBResponse.getSentStatus() != "")
            return true;
        throw new IllegalArgumentException();
    }

    public boolean validateClientCResponse(MessageServiceClientCResponse messageServiceClientCResponse)
    {
        if (messageServiceClientCResponse.getSentStatus() != null &&
                messageServiceClientCResponse.getSentStatus() != "")
            return true;
        throw new IllegalArgumentException();
    }
}
