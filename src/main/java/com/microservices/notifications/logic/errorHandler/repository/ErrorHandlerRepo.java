package com.microservices.notifications.logic.errorHandler.repository;

import com.microservices.notifications.logic.errorHandler.entity.ErrorHandler;
import com.microservices.notifications.logic.errorHandler.repository.customRepo.CustomErrorHandlerRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ErrorHandlerRepo extends MongoRepository<ErrorHandler, Long>, CustomErrorHandlerRepository {
}
