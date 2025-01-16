package com.microservices.notifications.logic.errorHandler;

public class ErrorHandlingRequest {

    public String serviceName;
    public String exMessage;
    public String exFullInfo;

    public ErrorHandlingRequest() {
    }

    public ErrorHandlingRequest(String serviceName, String exMessage, String exFullInfo) {
        this.serviceName = serviceName;
        this.exMessage = exMessage;
        this.exFullInfo = exFullInfo;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getExMessage() {
        return exMessage;
    }

    public void setExMessage(String exMessage) {
        this.exMessage = exMessage;
    }

    public String getExFullInfo() {
        return exFullInfo;
    }

    public void setExFullInfo(String exFullInfo) {
        this.exFullInfo = exFullInfo;
    }

    @Override
    public String toString() {
        return "ErrorHandlingRequest{" +
                "serviceName='" + serviceName + '\'' +
                ", exMessage='" + exMessage + '\'' +
                ", exFullInfo='" + exFullInfo + '\'' +
                '}';
    }
}
