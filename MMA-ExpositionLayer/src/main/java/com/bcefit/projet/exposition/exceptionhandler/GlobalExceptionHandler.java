package com.bcefit.projet.exposition.exceptionhandler;

import com.bcefit.projet.exposition.user.dto.MessageExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<MessageExceptionDto> handleProduitNotFoundExeption (EntityNotFoundException ex) {
        MessageExceptionDto errorMessage=new MessageExceptionDto("NOT_FOUND",ex.getMessage(),new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

}
