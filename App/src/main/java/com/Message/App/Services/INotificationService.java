package com.Message.App.Services;

import com.Message.App.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTO.MessageServiceResponseDTO;

public interface INotificationService
{
    public String getCountryCode(MessageServiceRequestDTO messageServiceRequestDTO);

    public MessageServiceEnum getMessageService(String countryCode);

    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO);

}
