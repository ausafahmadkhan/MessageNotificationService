package com.Message.App.Clients.ClientA;

import com.Message.App.InternalContracts.MessageServiceClientA.MessageServiceClientARequest;
import com.Message.App.InternalContracts.MessageServiceClientA.MessageServiceClientAResponse;
import org.springframework.web.bind.annotation.RequestBody;
import retrofit2.Call;
import retrofit2.http.POST;

public interface IMessageServiceClientA
{
    @POST("/path")
    Call<MessageServiceClientAResponse> sendMessage(@RequestBody MessageServiceClientARequest messageServiceClientARequest);
}
