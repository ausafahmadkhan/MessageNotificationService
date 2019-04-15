package com.Message.App.Clients.ClientB;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class MessageServiceClientBConfig
{
    private Retrofit retrofit;

    public MessageServiceClientBConfig()
    {
        retrofit = new Retrofit.Builder()
                        .baseUrl("http://localhost:8080")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
    }

    @Bean
    public IMessageServiceClientB getClientB()
    {
        return retrofit.create(IMessageServiceClientB.class);
    }
}
