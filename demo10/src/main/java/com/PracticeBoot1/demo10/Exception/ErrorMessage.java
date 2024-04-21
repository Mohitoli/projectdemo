package com.PracticeBoot1.demo10.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage  {
    private HttpStatus httpStatus;
    private String message;
}
