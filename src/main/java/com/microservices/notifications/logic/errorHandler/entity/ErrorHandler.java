package com.microservices.notifications.logic.errorHandler.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "error_logs")
public class ErrorHandler {

    @Transient
    public static final String SEQUENCE_COMMENTS = "error_logs_sequence";

    @Id
    public Long id;
    public String serviceName;
    public String exMessage;
    public String exFullInfo;
    public Date createdAt;

    public ErrorHandler(){

    }
    public ErrorHandler(Long id, String serviceName, String exMessage, String exFullInfo, Date createdAt) {
        this.id = id;
        this.serviceName = serviceName;
        this.exMessage = exMessage;
        this.exFullInfo = exFullInfo;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ErrorHandler{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", exMessage='" + exMessage + '\'' +
                ", exFullInfo='" + exFullInfo + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
