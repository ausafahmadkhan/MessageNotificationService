package com.Message.App.Services;

import com.Message.App.InternalContracts.MessageServiceClientA.MessageServiceClientARequest;
import com.Message.App.InternalContracts.MessageServiceClientA.MessageServiceClientAResponse;
import com.Message.App.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTO.MessageServiceResponseDTO;
import com.Message.App.Mapper.MessageServiceMapper;
import com.Message.App.Validator.MessageServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "MessageServiceA")
public class MessageServiceA implements IMessageService
{
    @Autowired
    private MessageServiceValidator messageServiceValidator;
    @Autowired
    private MessageServiceMapper messageServiceMapper;

    @Override
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        MessageServiceClientARequest clientARequest = messageServiceMapper.dtoToClientARequest(messageServiceRequestDTO);
        MessageServiceClientAResponse clientAResponse = new MessageServiceClientAResponse();
        //api call
        messageServiceValidator.validateClientAResponse(clientAResponse);
        MessageServiceResponseDTO messageServiceResponseDTO = messageServiceMapper.clientAResponseToDto(clientAResponse);
        return messageServiceResponseDTO;
    }
}
