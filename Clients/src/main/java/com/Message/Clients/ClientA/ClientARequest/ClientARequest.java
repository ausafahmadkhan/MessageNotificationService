package com.Message.Clients.ClientA.ClientARequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientARequest
{
    private String phoneNumber;
    private String messageBody;
}
