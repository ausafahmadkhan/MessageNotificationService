package com.Message.App.InternalContracts.MessageServiceClientC;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageServiceClientCResponse
{
    private String sentStatus;
}
