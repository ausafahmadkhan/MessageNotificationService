package com.Message.App.MessageServiceDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageServiceRequestDTO
{
    private String phoneNumber;
    private String messageBody;
}