package com.Message.App.Services;

import com.Message.App.DTOs.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.DTOs.MessageServiceDTO.MessageServiceResponseDTO;
import com.Message.App.Mappers.MessageServiceMapper.MessageServiceMapper;
import com.Message.App.Validators.MessageValidator.MessageValidator;
import com.Message.Clients.ClientC.ClientCRequest.ClientCRequest;
import com.Message.Clients.ClientC.ClientCResponse.ClientCResponse;
import com.Message.Clients.ClientC.ClientCService.ClientCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "MessageServiceC")
public class MessageServiceC implements IMessageService
{
    @Autowired
    private ClientCService clientCService;

    @Autowired
    private MessageServiceMapper messageServiceMapper;

    @Autowired
    private MessageValidator messageValidator;

    @Override
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        ClientCRequest clientCRequest = messageServiceMapper.dtoToClientCRequest(messageServiceRequestDTO);
        ClientCResponse clientCResponse = clientCService.sendMessage(clientCRequest);
        MessageServiceResponseDTO messageServiceResponseDTO = messageServiceMapper.clientCResponseToDto(clientCResponse);
        return messageServiceResponseDTO;
    }
}
