package arquitectura.software.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import arquitectura.software.demo.dto.ErrorApiDto;
import arquitectura.software.demo.dto.ErrorServiceDto;
import arquitectura.software.demo.exception.ServiceException;

@RestControllerAdvice
public class ControllerAdvice {
    
    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ErrorServiceDto> serviceException(ServiceException ex) {
        ErrorServiceDto error = new ErrorServiceDto(new ErrorApiDto(ex.getCode(), ex.getMessage()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    
}
