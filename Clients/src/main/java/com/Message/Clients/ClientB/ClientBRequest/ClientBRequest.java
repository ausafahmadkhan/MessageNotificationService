package com.Message.Clients.ClientB.ClientBRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientBRequest
{
    private String phoneNumber;
    private String messageBody;
}
