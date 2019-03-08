package com.Message.App.InternalContracts.MessageServiceClientA;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageServiceClientARequest
{
    private String phoneNumber;
    private String messageBody;
}
