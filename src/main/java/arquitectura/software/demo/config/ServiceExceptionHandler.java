package arquitectura.software.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import arquitectura.software.demo.dto.ErrorApiDto;
import arquitectura.software.demo.exception.ServiceException;

@ControllerAdvice
public class ServiceExceptionHandler {
    
    @ExceptionHandler(value = {ServiceException.class})
    public ErrorApiDto serviceException(ServiceException ex, WebRequest request) {
        ErrorApiDto message = new ErrorApiDto(HttpStatus.BAD_REQUEST.toString(), "request not found");
        return message;
    }
}
