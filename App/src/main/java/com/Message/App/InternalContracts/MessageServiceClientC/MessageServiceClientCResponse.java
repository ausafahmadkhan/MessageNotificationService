package com.Message.App.InternalContracts.MessageServiceClientC;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("status")
    private String sentStatus;

    @JsonProperty("message")
    private String message;
}
