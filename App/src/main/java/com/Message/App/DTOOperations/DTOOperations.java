package com.Message.App.DTOOperations;

import com.Message.App.DTOs.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.Persistence.Model.MessageServiceLookup;
import com.Message.App.Persistence.Repository.MessageServiceRepository;
import com.Message.App.Services.MessageServiceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOOperations
{
    @Autowired
    private MessageServiceRepository messageServiceRepository;

    public String getCountryCode(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        return messageServiceRequestDTO.getPhoneNumber().substring(0, 3);
    }
    public MessageServiceEnum getMessageService(String countryCode)
    {
        MessageServiceLookup messageServiceLookup = messageServiceRepository.findById(countryCode).orElse(null);
        if (messageServiceLookup != null)
        {
            String messageServiceName = messageServiceLookup.getMessageServiceName();
            for (MessageServiceEnum messageServiceEnum : MessageServiceEnum.values())
            {
                if (messageServiceEnum.name() == messageServiceName)
                    return messageServiceEnum;
            }
        }
        throw new IllegalArgumentException();
    }

}
