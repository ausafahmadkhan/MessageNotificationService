package com.Message.App.MessageServiceMapper;

import com.Message.App.InternalContracts.MessageServiceClientA.MessageServiceClientARequest;
import com.Message.App.InternalContracts.MessageServiceClientA.MessageServiceClientAResponse;
import com.Message.App.InternalContracts.MessageServiceClientB.MessageServiceClientBRequest;
import com.Message.App.InternalContracts.MessageServiceClientB.MessageServiceClientBResponse;
import com.Message.App.InternalContracts.MessageServiceClientC.MessageServiceClientCRequest;
import com.Message.App.InternalContracts.MessageServiceClientC.MessageServiceClientCResponse;
import com.Message.App.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTO.MessageServiceResponseDTO;
import com.Message.Contracts.MessageRequest.MessageRequest;
import com.Message.Contracts.MessageResponse.MessageResponse;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceMapper
{
    public MessageServiceRequestDTO messageRequestToDto(MessageRequest messageRequest)
    {
        MessageServiceRequestDTO messageServiceRequestDTO = new MessageServiceRequestDTO();
        messageServiceRequestDTO.setPhoneNumber(messageRequest.getPhoneNumber());
        messageServiceRequestDTO.setMessageBody(messageRequest.getMessageBody());
        return messageServiceRequestDTO;
    }
    public MessageResponse dtoToMessageResponse(MessageServiceResponseDTO messageServiceResponseDTO)
    {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setSentStatus(messageServiceResponseDTO.getSentStatus());
        return messageResponse;
    }
    public MessageServiceClientARequest dtoToClientARequest(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        MessageServiceClientARequest clientARequest = new MessageServiceClientARequest();
        clientARequest.setPhoneNumber(messageServiceRequestDTO.getPhoneNumber());
        clientARequest.setMessageBody(messageServiceRequestDTO.getMessageBody());
        return clientARequest;
    }
    public MessageServiceResponseDTO clientAResponseToDto(MessageServiceClientAResponse clientAResponse)
    {
        MessageServiceResponseDTO messageServiceResponseDTO = new MessageServiceResponseDTO();
        messageServiceResponseDTO.setSentStatus(clientAResponse.getSentStatus());
        return messageServiceResponseDTO;
    }
    public MessageServiceClientBRequest dtoToClientBRequest(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        MessageServiceClientBRequest clientBRequest = new MessageServiceClientBRequest();
        clientBRequest.setPhoneNumber(messageServiceRequestDTO.getPhoneNumber());
        clientBRequest.setMessageBody(messageServiceRequestDTO.getMessageBody());
        return clientBRequest;
    }
    public MessageServiceResponseDTO clientBResponseToDto(MessageServiceClientBResponse clientBResponse)
    {
        MessageServiceResponseDTO messageServiceResponseDTO = new MessageServiceResponseDTO();
        messageServiceResponseDTO.setSentStatus(clientBResponse.getSentStatus());
        return messageServiceResponseDTO;
    }
    public MessageServiceClientCRequest dtoToClientCRequest(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        MessageServiceClientCRequest clientCRequest = new MessageServiceClientCRequest();
        clientCRequest.setPhoneNumber(messageServiceRequestDTO.getPhoneNumber());
        clientCRequest.setMessageBody(messageServiceRequestDTO.getMessageBody());
        return clientCRequest;
    }
    public MessageServiceResponseDTO clientCResponseToDto(MessageServiceClientCResponse clientCResponse)
    {
        MessageServiceResponseDTO messageServiceResponseDTO = new MessageServiceResponseDTO();
        messageServiceResponseDTO.setSentStatus(clientCResponse.getSentStatus());
        return messageServiceResponseDTO;
    }
}
