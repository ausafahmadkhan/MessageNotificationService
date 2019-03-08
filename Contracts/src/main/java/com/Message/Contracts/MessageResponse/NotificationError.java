package com.Message.Contracts.MessageResponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationError
{
    private String errorMessage;
    private HttpStatus httpStatus;
    private StackTraceElement stackTraceElement[];
}
