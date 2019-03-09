package com.Message.App.Services;

import com.Message.App.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTO.MessageServiceResponseDTO;
import com.Message.App.Persistence.Model.ServiceCountryMapDAO;
import com.Message.App.Persistence.Repository.MessageServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class NotificationService implements INotificationService
{
    @Autowired
    private Map<String, IMessageService> messageServiceMap;

    @Autowired
    private MessageServiceRepository messageServiceRepository;

    private String getCountryCode(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        return messageServiceRequestDTO.getPhoneNumber().substring(0, 3);
    }
    private MessageServiceEnum getMessageService(String countryCode)
    {
        ServiceCountryMapDAO serviceCountryMapDAO = messageServiceRepository.findById(countryCode).orElse(null);
        if (serviceCountryMapDAO != null)
        {
            String messageServiceName = serviceCountryMapDAO.getMessageServiceName();
            for (MessageServiceEnum messageServiceEnum : MessageServiceEnum.values())
            {
                if (messageServiceEnum.name() == messageServiceName)
                    return messageServiceEnum;
            }
        }
        throw new IllegalArgumentException();
    }
    @Override
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO)
    {
        String countryCode = getCountryCode(messageServiceRequestDTO);
        MessageServiceEnum messageServiceEnum = getMessageService(countryCode);
        IMessageService messageService = messageServiceMap.get(messageServiceEnum.toString());
        MessageServiceResponseDTO messageServiceResponseDTO = messageService.sendMessage(messageServiceRequestDTO);
        return messageServiceResponseDTO;
    }

}
