package com.Message.App.Clients.ClientB;

import com.Message.App.InternalContracts.MessageServiceClientB.MessageServiceClientBRequest;
import com.Message.App.InternalContracts.MessageServiceClientB.MessageServiceClientBResponse;
import org.springframework.web.bind.annotation.RequestBody;
import retrofit2.Call;
import retrofit2.http.POST;

public interface IMessageServiceClientB
{
    @POST("/path")
    Call<MessageServiceClientBResponse> sendMessage(@RequestBody MessageServiceClientBRequest messageServiceClientBRequest);
}
