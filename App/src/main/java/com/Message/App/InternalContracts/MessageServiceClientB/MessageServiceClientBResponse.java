package com.Message.App.InternalContracts.MessageServiceClientB;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageServiceClientBResponse
{
    private String sentStatus;
}
