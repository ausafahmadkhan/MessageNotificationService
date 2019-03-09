package com.Message.App.Controllers;


import com.Message.App.DTOOperations.DTOOperations;
import com.Message.App.MessageServiceDTO.MessageServiceRequestDTO;
import com.Message.App.MessageServiceDTO.MessageServiceResponseDTO;
import com.Message.App.Mapper.MessageServiceMapper;
import com.Message.App.Services.INotificationService;
import com.Message.App.Validator.MessageServiceValidator;
import com.Message.Contracts.MessageResponse.NotificationError;
import com.Message.Contracts.MessageRequest.MessageRequest;
import com.Message.Contracts.MessageResponse.MessageResponse;
import com.Message.Contracts.MessageResponse.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/NotificationService")
public class NotificationController
{
    @Autowired
    private MessageServiceValidator messageServiceValidator;

    @Autowired
    private MessageServiceMapper messageServiceMapper;

    @Autowired
    private INotificationService notificationService;

    @RequestMapping(path = "/sendMessage", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<ResponseModel<MessageResponse>> sendMessage(@RequestBody MessageRequest messageRequest)
    {
        MessageResponse messageResponse = new MessageResponse();
        NotificationError notificationError = new NotificationError();
        try
        {
            messageServiceValidator.validateMessageRequest(messageRequest);
            MessageServiceRequestDTO messageServiceRequestDTO = messageServiceMapper.messageRequestToDto(messageRequest);
            messageServiceValidator.validateMessageServiceRequestDTO(messageServiceRequestDTO);
            MessageServiceResponseDTO messageServiceResponseDTO = notificationService.sendMessage(messageServiceRequestDTO);
            messageServiceValidator.validateMessageServiceResponseDTO(messageServiceResponseDTO);
            messageResponse = messageServiceMapper.dtoToMessageResponse(messageServiceResponseDTO);
            messageServiceValidator.validateMessageResponse(messageResponse);
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
