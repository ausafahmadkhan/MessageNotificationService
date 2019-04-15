package com.Message.App.Clients.ClientC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class MessageServiceClientCConfig
{
    private Retrofit retrofit;

    public MessageServiceClientCConfig()
    {
        retrofit = new Retrofit.Builder()
                        .baseUrl("http://localhost:8080")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
    }

    @Bean
    public IMessageServiceClientC getClientC()
    {
        return retrofit.create(IMessageServiceClientC.class);
    }
}
