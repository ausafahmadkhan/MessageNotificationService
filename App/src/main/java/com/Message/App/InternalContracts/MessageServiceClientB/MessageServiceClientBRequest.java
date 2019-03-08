package com.Message.App.InternalContracts.MessageServiceClientB;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageServiceClientBRequest
{
    private String phoneNumber;
    private String messageBody;
}
