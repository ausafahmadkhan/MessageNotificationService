package com.Message.App.Services;

import com.Message.App.DTOs.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.DTOs.MessageServiceDTO.MessageServiceResponseDTO;

public interface IMessageService
{
    public MessageServiceResponseDTO sendMessage(MessageServiceRequestDTO messageServiceRequestDTO);
}
