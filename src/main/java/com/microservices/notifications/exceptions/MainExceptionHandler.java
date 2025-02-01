package com.microservices.notifications.exceptions;


import com.microservices.shared_utils.statusResponces.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.microservices.shared_utils.constants.Constants.ERROR_MESSAGE;

@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<StatusResponse> exception(Exception ex) {
        ex.printStackTrace();

        return new ResponseEntity<>(
                new StatusResponse(
                        false,
                        ERROR_MESSAGE
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
