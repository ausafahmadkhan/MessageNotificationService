package com.Message.App.InternalContracts.MessageServiceClientC;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageServiceClientCRequest
{
    private String phoneNumber;
    private String messageBody;
}
