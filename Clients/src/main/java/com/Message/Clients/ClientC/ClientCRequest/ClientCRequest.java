package com.Message.Clients.ClientC.ClientCRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientCRequest
{
    private String phoneNumber;
    private String messageBody;
}
