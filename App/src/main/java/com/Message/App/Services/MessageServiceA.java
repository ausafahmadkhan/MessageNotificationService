package com.Message.App.Services;

import com.Message.App.InternalContracts.MessageServiceClientA.MessageServiceClientARequest;
import com.Message.App.InternalContracts.MessageServiceClientA.MessageServiceClientAResponse;
import com.Message.App.MessageServiceDTOS.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTOS.MessageServiceResponseDTO;
import com.Message.App.Mapper.MessageServiceMapper;
import com.Message.App.Validator.MessageServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

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
        clientAResponse = callClientA(clientARequest);
        messageServiceValidator.validateClientAResponse(clientAResponse);
        MessageServiceResponseDTO messageServiceResponseDTO = messageServiceMapper.clientAResponseToDto(clientAResponse);
        return messageServiceResponseDTO;
    }

    private MessageServiceClientAResponse callClientA(MessageServiceClientARequest messageServiceClientARequest)
    {
        MessageServiceClientAResponse messageServiceClientAResponse = new MessageServiceClientAResponse();
        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://localhost:8080/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
        IMessageServiceAAPI messageServiceAAPI = retrofit.create(IMessageServiceAAPI.class);
        Call<MessageServiceClientAResponse> clientAResponseCall = messageServiceAAPI.getMessage(messageServiceClientARequest);
        try {
            Response<MessageServiceClientAResponse> response = clientAResponseCall.execute();
            if (response.isSuccessful()) {
                messageServiceClientAResponse = response.body();
                messageServiceClientAResponse.setStatusCode(response.code());
            } else {
                messageServiceClientAResponse.setSentStatus("");
                messageServiceClientAResponse.setStatusCode(response.code());
                System.err.println(response.errorBody());
            }
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
        return messageServiceClientAResponse;
    }
}
