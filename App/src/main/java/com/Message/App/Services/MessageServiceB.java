package com.Message.App.Services;



import com.Message.App.DTOs.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.DTOs.MessageServiceDTO.MessageServiceResponseDTO;

import com.Message.App.Mappers.MessageServiceMapper.MessageServiceMapper;

import com.Message.App.Validators.MessageValidator.MessageValidator;
import com.Message.Clients.ClientB.ClientBRequest.ClientBRequest;
import com.Message.Clients.ClientB.ClientBResponse.ClientBResponse;
import com.Message.Clients.ClientB.ClientBService.ClientBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "MessageServiceB")
public class MessageServiceB implements IMessageService
{
    @Autowired
    private ClientBService clientBService;

    @Autowired
    private MessageServiceMapper messageServiceMapper;

    @Autowired
    private MessageValidator messageValidator;

    @Override
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        ClientBRequest clientBRequest = messageServiceMapper.dtoToClientBRequest(messageServiceRequestDTO);
        ClientBResponse clientBResponse = clientBService.sendMessage(clientBRequest);
        MessageServiceResponseDTO messageServiceResponseDTO = messageServiceMapper.clientBResponseToDto(clientBResponse);
        return messageServiceResponseDTO;
    }
}
