package com.Message.App.Mappers.MessageServiceMapper;

import com.Message.App.DTOs.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.DTOs.MessageServiceDTO.MessageServiceResponseDTO;
import com.Message.Clients.ClientA.ClientARequest.ClientARequest;
import com.Message.Clients.ClientA.ClientAResponse.ClientAResponse;
import com.Message.Clients.ClientB.ClientBRequest.ClientBRequest;
import com.Message.Clients.ClientB.ClientBResponse.ClientBResponse;
import com.Message.Clients.ClientC.ClientCRequest.ClientCRequest;
import com.Message.Clients.ClientC.ClientCResponse.ClientCResponse;
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
    public ClientARequest dtoToClientARequest(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        ClientARequest clientARequest = new ClientARequest();
        clientARequest.setPhoneNumber(messageServiceRequestDTO.getPhoneNumber());
        clientARequest.setMessageBody(messageServiceRequestDTO.getMessageBody());
        return clientARequest;
    }
    public MessageServiceResponseDTO clientAResponseToDto(ClientAResponse clientAResponse)
    {
        MessageServiceResponseDTO messageServiceResponseDTO = new MessageServiceResponseDTO();
        messageServiceResponseDTO.setSentStatus(clientAResponse.getSentStatus());
        return messageServiceResponseDTO;
    }
    public ClientBRequest dtoToClientBRequest(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        ClientBRequest clientBRequest = new ClientBRequest();
        clientBRequest.setPhoneNumber(messageServiceRequestDTO.getPhoneNumber());
        clientBRequest.setMessageBody(messageServiceRequestDTO.getMessageBody());
        return clientBRequest;
    }
    public MessageServiceResponseDTO clientBResponseToDto(ClientBResponse clientBResponse)
    {
        MessageServiceResponseDTO messageServiceResponseDTO = new MessageServiceResponseDTO();
        messageServiceResponseDTO.setSentStatus(clientBResponse.getSentStatus());
        return messageServiceResponseDTO;
    }
    public ClientCRequest dtoToClientCRequest(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        ClientCRequest clientCRequest = new ClientCRequest();
        clientCRequest.setPhoneNumber(messageServiceRequestDTO.getPhoneNumber());
        clientCRequest.setMessageBody(messageServiceRequestDTO.getMessageBody());
        return clientCRequest;
    }
    public MessageServiceResponseDTO clientCResponseToDto(ClientCResponse clientCResponse)
    {
        MessageServiceResponseDTO messageServiceResponseDTO = new MessageServiceResponseDTO();
        messageServiceResponseDTO.setSentStatus(clientCResponse.getSentStatus());
        return messageServiceResponseDTO;
    }
}
