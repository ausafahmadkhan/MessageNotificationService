package com.Message.App.MessageServiceDTOS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageServiceResponseDTO
{
    private String sentStatus;
}
