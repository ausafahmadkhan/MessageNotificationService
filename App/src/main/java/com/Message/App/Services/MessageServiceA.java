package com.Message.App.Services;

import com.Message.App.Clients.ClientA.IMessageServiceClientA;
import com.Message.App.InternalContracts.MessageServiceClientA.MessageServiceClientARequest;
import com.Message.App.InternalContracts.MessageServiceClientA.MessageServiceClientAResponse;
import com.Message.App.MessageServiceDTOS.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTOS.MessageServiceResponseDTO;
import com.Message.App.Mapper.MessageServiceMapper;
import com.Message.App.Validator.MessageServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;

@Service(value = "MessageServiceA")
public class MessageServiceA implements IMessageService
{
    @Autowired
    private MessageServiceValidator messageServiceValidator;

    @Autowired
    private MessageServiceMapper messageServiceMapper;

    @Autowired
    private IMessageServiceClientA messageServiceClientA;

    @Override
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO) throws IOException
    {
        MessageServiceClientARequest clientARequest = messageServiceMapper.dtoToClientARequest(messageServiceRequestDTO);
        try {
            Response<MessageServiceClientAResponse> clientAResponse = messageServiceClientA.sendMessage(clientARequest).execute();
            MessageServiceClientAResponse messageServiceClientAResponse = clientAResponse.body();
            messageServiceValidator.validateClientAResponse(messageServiceClientAResponse);
            MessageServiceResponseDTO messageServiceResponseDTO = messageServiceMapper.clientAResponseToDto(messageServiceClientAResponse);
            return messageServiceResponseDTO;
        }
        catch (IOException e)
        {
            throw e;
        }
    }
}
