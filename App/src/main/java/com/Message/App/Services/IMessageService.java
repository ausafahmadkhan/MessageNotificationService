package com.Message.App.Services;

import com.Message.App.MessageServiceDTOS.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTOS.MessageServiceResponseDTO;

public interface IMessageService
{
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO);
}
