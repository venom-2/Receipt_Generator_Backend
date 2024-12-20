package com.receipt.generator.exception_handler;

import com.receipt.generator.dto.ExceptionResponse;
import com.receipt.generator.exceptions.DuplicateResource;
import com.receipt.generator.exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResource.class)
    public ResponseEntity<ExceptionResponse> handleDuplicateResource(DuplicateResource duplicateResource) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.IM_USED.value(), duplicateResource.getMessage());
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFound(ResourceNotFound resourceNotFound) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), resourceNotFound.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Optionally, you can handle other general exceptions here
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGeneralException(Exception ex) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred.");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
