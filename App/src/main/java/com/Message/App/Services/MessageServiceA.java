package com.Message.App.Services;

import com.Message.App.DTOs.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.DTOs.MessageServiceDTO.MessageServiceResponseDTO;
import com.Message.App.Mappers.MessageServiceMapper.MessageServiceMapper;
import com.Message.Clients.ClientA.ClientARequest.ClientARequest;
import com.Message.Clients.ClientA.ClientAResponse.ClientAResponse;
import com.Message.Clients.ClientA.ClientAService.ClientAService;
import com.Message.Clients.ClientA.ClientAValidator.ClientAValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "MessageServiceA")
public class MessageServiceA implements IMessageService
{
    @Autowired
    private ClientAService clientAService;

    @Autowired
    private MessageServiceMapper messageServiceMapper;

    @Autowired
    private ClientAValidator clientAValidator;

    @Override
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        ClientARequest clientARequest = messageServiceMapper.dtoToClientARequest(messageServiceRequestDTO);
        ClientAResponse clientAResponse = clientAService.sendMessage(clientARequest);
        clientAValidator.validateClientAResponse(clientAResponse);
        MessageServiceResponseDTO messageServiceResponseDTO = messageServiceMapper.clientAResponseToDto(clientAResponse);
        return messageServiceResponseDTO;
    }
}
