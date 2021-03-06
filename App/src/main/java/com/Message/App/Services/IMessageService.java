package com.Message.App.Services;

import com.Message.App.MessageServiceDTOS.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTOS.MessageServiceResponseDTO;

import java.io.IOException;

public interface IMessageService
{
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO) throws IOException;
}
