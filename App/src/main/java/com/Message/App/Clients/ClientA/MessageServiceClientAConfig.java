package com.Message.App.Clients.ClientA;

import com.Message.App.Clients.ClientA.IMessageServiceClientA;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class MessageServiceClientAConfig
{
    private Retrofit retrofit;

    public MessageServiceClientAConfig()
    {
        retrofit = new Retrofit.Builder()
                            .baseUrl("http://localhost:8080")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
    }

    @Bean
    public IMessageServiceClientA getClientA()
    {
        return retrofit.create(IMessageServiceClientA.class);
    }
}
