package com.Message.App.Services;



import com.Message.App.Clients.ClientB.IMessageServiceClientB;
import com.Message.App.InternalContracts.MessageServiceClientB.MessageServiceClientBRequest;
import com.Message.App.InternalContracts.MessageServiceClientB.MessageServiceClientBResponse;
import com.Message.App.MessageServiceDTOS.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTOS.MessageServiceResponseDTO;

import com.Message.App.Mapper.MessageServiceMapper;

import com.Message.App.Validator.MessageServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;

@Service(value = "MessageServiceB")
public class MessageServiceB implements IMessageService
{
    @Autowired
    private MessageServiceValidator messageServiceValidator;

    @Autowired
    private MessageServiceMapper messageServiceMapper;

    @Autowired
    private IMessageServiceClientB messageServiceClientB;

    @Override
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO) throws IOException
    {
        MessageServiceClientBRequest clientBRequest = messageServiceMapper.dtoToClientBRequest(messageServiceRequestDTO);
        try {
            Response<MessageServiceClientBResponse> response = messageServiceClientB.sendMessage(clientBRequest).execute();
            MessageServiceClientBResponse clientBResponse = response.body();
            messageServiceValidator.validateClientBResponse(clientBResponse);
            MessageServiceResponseDTO messageServiceResponseDTO = messageServiceMapper.clientBResponseToDto(clientBResponse);
            return messageServiceResponseDTO;
        }
        catch (IOException e)
        {
            throw e;
        }
    }
}
