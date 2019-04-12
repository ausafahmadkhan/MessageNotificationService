package com.Message.App.InternalContracts.MessageServiceClientA;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageServiceClientAResponse
{
    private String sentStatus;
    private int statusCode;
}
