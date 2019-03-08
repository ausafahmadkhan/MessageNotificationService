package com.Message.App.Validators.MessageValidator;

import com.Message.App.DTOs.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.DTOs.MessageServiceDTO.MessageServiceResponseDTO;
import com.Message.Contracts.MessageRequest.MessageRequest;
import com.Message.Contracts.MessageResponse.MessageResponse;
import org.springframework.stereotype.Component;

@Component
public class MessageValidator
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
    public boolean validateMessageServiceRequestDTO(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        if (messageServiceRequestDTO.getPhoneNumber() != "" &&
            messageServiceRequestDTO.getPhoneNumber() != null &&
            messageServiceRequestDTO.getMessageBody() != "" &&
            messageServiceRequestDTO.getMessageBody() != null &&
            messageServiceRequestDTO.getPhoneNumber().length() == 13)
            return true;
        throw new IllegalArgumentException();
    }
    public boolean validateMessageServiceResponseDTO(MessageServiceResponseDTO messageServiceResponseDTO)
    {
        if (messageServiceResponseDTO.getSentStatus() != null &&
                messageServiceResponseDTO.getSentStatus() != "")
            return true;
        throw new IllegalArgumentException();
    }
}
