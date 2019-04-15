package com.Message.App.Clients.ClientC;

import com.Message.App.InternalContracts.MessageServiceClientC.MessageServiceClientCRequest;
import com.Message.App.InternalContracts.MessageServiceClientC.MessageServiceClientCResponse;
import org.springframework.web.bind.annotation.RequestBody;
import retrofit2.Call;
import retrofit2.http.POST;



public interface IMessageServiceClientC
{
    @POST("/path")
    Call<MessageServiceClientCResponse> sendMessage(@RequestBody MessageServiceClientCRequest messageServiceClientCRequest);
}
