package com.Message.App.Services;

import com.Message.App.Clients.ClientC.IMessageServiceClientC;
import com.Message.App.InternalContracts.MessageServiceClientC.MessageServiceClientCRequest;
import com.Message.App.InternalContracts.MessageServiceClientC.MessageServiceClientCResponse;
import com.Message.App.MessageServiceDTOS.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTOS.MessageServiceResponseDTO;
import com.Message.App.Mapper.MessageServiceMapper;
import com.Message.App.Validator.MessageServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;

@Service(value = "MessageServiceC")
public class MessageServiceC implements IMessageService
{
    @Autowired
    private MessageServiceValidator messageServiceValidator;

    @Autowired
    private MessageServiceMapper messageServiceMapper;

    @Autowired
    private IMessageServiceClientC messageServiceClientC;

    @Override
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO) throws IOException
    {
        MessageServiceClientCRequest clientCRequest = messageServiceMapper.dtoToClientCRequest(messageServiceRequestDTO);
        try {
            Response<MessageServiceClientCResponse> response = messageServiceClientC.sendMessage(clientCRequest).execute();
            MessageServiceClientCResponse clientCResponse = response.body();
            messageServiceValidator.validateClientCResponse(clientCResponse);
            MessageServiceResponseDTO messageServiceResponseDTO = messageServiceMapper.clientCResponseToDto(clientCResponse);
            return messageServiceResponseDTO;
        }
        catch (IOException e)
        {
            throw e;
        }
    }
}
