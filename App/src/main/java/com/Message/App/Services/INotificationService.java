package com.Message.App.Services;

import com.Message.App.MessageServiceDTOS.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTOS.MessageServiceResponseDTO;

public interface INotificationService
{
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO);

}
