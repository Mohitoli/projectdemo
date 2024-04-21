package com.Project_spring.demo11.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityException extends ResponseEntityExceptionHandler {
 @ExceptionHandler(UserNotFoundException.class)
     public ResponseEntity<ErrorMessage>  Usernotfoundexception(UserNotFoundException usernotfound, WebRequest request){
ErrorMessage message =  new ErrorMessage(HttpStatus.NOT_FOUND, usernotfound.getMessage());
return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(message);

     }
}
