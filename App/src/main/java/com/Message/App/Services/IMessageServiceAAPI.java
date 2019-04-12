package com.Message.App.Services;


import com.Message.App.InternalContracts.MessageServiceClientA.MessageServiceClientARequest;
import com.Message.App.InternalContracts.MessageServiceClientA.MessageServiceClientAResponse;
import org.springframework.web.bind.annotation.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IMessageServiceAAPI
{
    @GET("/path")
    Call<MessageServiceClientAResponse> getMessage(@RequestBody MessageServiceClientARequest messageServiceClientARequest);
}
