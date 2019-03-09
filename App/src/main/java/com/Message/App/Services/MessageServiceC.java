package com.Message.App.Services;

import com.Message.App.InternalContracts.MessageServiceClientC.MessageServiceClientCRequest;
import com.Message.App.InternalContracts.MessageServiceClientC.MessageServiceClientCResponse;
import com.Message.App.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTO.MessageServiceResponseDTO;
import com.Message.App.Mapper.MessageServiceMapper;
import com.Message.App.Validator.MessageServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "MessageServiceC")
public class MessageServiceC implements IMessageService
{
    @Autowired
    private MessageServiceValidator messageServiceValidator;
    @Autowired
    private MessageServiceMapper messageServiceMapper;

    @Override
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        MessageServiceClientCRequest clientCRequest = messageServiceMapper.dtoToClientCRequest(messageServiceRequestDTO);
        MessageServiceClientCResponse clientCResponse = new MessageServiceClientCResponse();
        //api call
        messageServiceValidator.validateClientCResponse(clientCResponse);
        MessageServiceResponseDTO messageServiceResponseDTO = messageServiceMapper.clientCResponseToDto(clientCResponse);
        return messageServiceResponseDTO;
    }
}
