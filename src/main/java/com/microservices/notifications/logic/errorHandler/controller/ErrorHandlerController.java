package com.microservices.notifications.logic.errorHandler.controller;


import com.microservices.notifications.logic.errorHandler.ErrorHandlingRequest;
import com.microservices.notifications.logic.errorHandler.service.ErrorHandlingService;
import com.microservices.shared_utils.statusResponces.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/notifications/error-reporting")
public class ErrorHandlerController {

    @Autowired
    private ErrorHandlingService errorHandlingService;

    @PostMapping("/report")
    public StatusResponse handleError(@RequestBody ErrorHandlingRequest errorHandlingRequest) throws Exception {
        return errorHandlingService.handleError(
                errorHandlingRequest.getServiceName(),
                errorHandlingRequest.getExMessage(),
                errorHandlingRequest.getExFullInfo()
        );
    }

    @GetMapping("/print-barcode")
    public ResponseEntity<Object> generateBarcode(@RequestParam String itemId, @RequestParam(required = false, defaultValue = "60") Integer height, @RequestParam(required = false, defaultValue = "230") Integer width) {
        return errorHandlingService.createBarcode(itemId, height, width);
    }

}
