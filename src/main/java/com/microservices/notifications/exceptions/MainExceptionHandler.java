package com.microservices.notifications.exceptions;


import com.microservices.shared_utils.constants.Constants;
import com.microservices.shared_utils.statusResponces.StandardStatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<StandardStatusResponse> exception(Exception ex) {
        ex.printStackTrace();

        return new ResponseEntity<>(
                new StandardStatusResponse(
                        false,
                        Constants.ERROR_MESSAGE
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
