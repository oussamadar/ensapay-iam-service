package ensa.pay.iamservice.exceptions;

import com.mongodb.MongoConfigurationException;
import com.mongodb.MongoSocketReadTimeoutException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException e , WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),e.getMessage(),request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);

    }

    //Global Exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleNotFoundException(Exception e , WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),e.getMessage(),request.getDescription(false));
        return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
