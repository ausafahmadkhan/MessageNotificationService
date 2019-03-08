package com.Message.App;


import com.Message.Clients.ClientA.ClientAService.ClientAService;
import com.Message.Clients.ClientA.ClientAValidator.ClientAValidator;
import com.Message.Clients.ClientB.ClientBService.ClientBService;
import com.Message.Clients.ClientB.ClientBValidator.ClientBValidator;
import com.Message.Clients.ClientC.ClientCService.ClientCService;
import com.Message.Clients.ClientC.ClientCValidator.ClientCValidator;
import com.Message.Contracts.MessageResponse.NotificationError;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App
{
    public static void main(String args[])
    {
        SpringApplication.run(App.class, args);
    }
    
}
