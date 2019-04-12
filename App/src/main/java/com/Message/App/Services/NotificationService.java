package com.Message.App.Services;

import com.Message.App.MessageServiceDTOS.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTOS.MessageServiceResponseDTO;
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
            MessageServiceEnum messageServiceEnum = MessageServiceEnum.valueOf(serviceCountryMapDAO.getMessageServiceName());
            return messageServiceEnum;
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
