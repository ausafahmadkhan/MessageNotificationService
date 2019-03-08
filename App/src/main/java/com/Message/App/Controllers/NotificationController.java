package com.Message.App.Controllers;


import com.Message.App.DTOOperations.DTOOperations;
import com.Message.App.DTOs.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.DTOs.MessageServiceDTO.MessageServiceResponseDTO;
import com.Message.App.Mappers.MessageServiceMapper.MessageServiceMapper;
import com.Message.App.Services.IMessageService;
import com.Message.App.Services.MessageServiceEnum;
import com.Message.App.Validators.MessageValidator.MessageValidator;
import com.Message.Contracts.MessageResponse.NotificationError;
import com.Message.Contracts.MessageRequest.MessageRequest;
import com.Message.Contracts.MessageResponse.MessageResponse;
import com.Message.Contracts.MessageResponse.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping(path = "/NotificationService")
public class NotificationController
{
    @Autowired
    private MessageValidator messageValidator;

    @Autowired
    private MessageServiceMapper messageServiceMapper;

    @Autowired
    private DTOOperations dtoOperations;

    @Autowired
    private Map<String, IMessageService> messageServiceMap;

    @RequestMapping(path = "/sendMessage", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<ResponseModel<MessageResponse>> sendMessage(@RequestBody MessageRequest messageRequest)
    {
        MessageResponse messageResponse = new MessageResponse();
        NotificationError notificationError = new NotificationError();
        try
        {
            messageValidator.validateMessageRequest(messageRequest);
            MessageServiceRequestDTO messageServiceRequestDTO = messageServiceMapper.messageRequestToDto(messageRequest);
            messageValidator.validateMessageServiceRequestDTO(messageServiceRequestDTO);
            String countryCode = dtoOperations.getCountryCode(messageServiceRequestDTO);
            MessageServiceEnum messageServiceEnum = dtoOperations.getMessageService(countryCode);
            IMessageService messageService = messageServiceMap.get(messageServiceEnum.toString());
            MessageServiceResponseDTO messageServiceResponseDTO = messageService.sendMessage(messageServiceRequestDTO);
            messageValidator.validateMessageServiceResponseDTO(messageServiceResponseDTO);
            messageResponse = messageServiceMapper.dtoToMessageResponse(messageServiceResponseDTO);
            messageValidator.validateMessageResponse(messageResponse);
        }
        catch (IllegalArgumentException e)
        {
            notificationError.setErrorMessage(e.getMessage());
            notificationError.setStackTraceElement(e.getStackTrace());
            notificationError.setHttpStatus(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e)
        {
            notificationError.setErrorMessage(e.getMessage());
            notificationError.setStackTraceElement(e.getStackTrace());
            notificationError.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally
        {
            if(notificationError != null)
            {
                messageResponse.setNotificationError(notificationError);
                return new ResponseEntity<ResponseModel<MessageResponse>>(new ResponseModel<MessageResponse>(messageResponse),notificationError.getHttpStatus());
            }
            else
            {
                return new ResponseEntity<ResponseModel<MessageResponse>>(new ResponseModel<MessageResponse>(messageResponse),HttpStatus.OK);
            }

        }
    }
}
