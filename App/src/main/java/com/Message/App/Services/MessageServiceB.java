package com.Message.App.Services;



import com.Message.App.InternalContracts.MessageServiceClientB.MessageServiceClientBRequest;
import com.Message.App.InternalContracts.MessageServiceClientB.MessageServiceClientBResponse;
import com.Message.App.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTO.MessageServiceResponseDTO;

import com.Message.App.MessageServiceMapper.MessageServiceMapper;

import com.Message.App.MessageServiceValidator.MessageServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "MessageServiceB")
public class MessageServiceB implements IMessageService
{
    @Autowired
    private MessageServiceValidator messageServiceValidator;
    @Autowired
    private MessageServiceMapper messageServiceMapper;

    @Override
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        MessageServiceClientBRequest clientBRequest = messageServiceMapper.dtoToClientBRequest(messageServiceRequestDTO);
        MessageServiceClientBResponse clientBResponse = new MessageServiceClientBResponse();
        //api call
        messageServiceValidator.validateClientBResponse(clientBResponse);
        MessageServiceResponseDTO messageServiceResponseDTO = messageServiceMapper.clientBResponseToDto(clientBResponse);
        return messageServiceResponseDTO;
    }
}
