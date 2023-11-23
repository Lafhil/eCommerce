package com.ecommerce.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        ErrorResponse errorObject = new ErrorResponse();
        if (ex.getCause() instanceof ConstraintViolationException) {
            errorObject.setMessage("Cet objet est référencé par d’autres entités");
            errorObject.setErrorCode(((ConstraintViolationException) ex.getCause()).getSQLException().getErrorCode());
            errorObject.setStatusCode(HttpStatus.CONFLICT);
            //errorObject.setTimestamp(new Date());
            return new ResponseEntity<ErrorResponse>(errorObject, HttpStatus.CONFLICT);
        }
        if (ex.getCause() instanceof DataException) {
            errorObject.setMessage("Cette entrée dépasse la taille max!");
            errorObject.setErrorCode(((DataException) ex.getCause()).getSQLException().getErrorCode());
            errorObject.setStatusCode(HttpStatus.BAD_REQUEST);
          //  errorObject.setTimestamp(new Date());
            return new ResponseEntity<ErrorResponse>(errorObject, HttpStatus.BAD_REQUEST);
        }
        if (ex.getCause() instanceof ParentSimilairToShild) {
            errorObject.setMessage("parent and shiled are a simmilare object!");
          //  errorObject.setErrorCode(((DataException) ex.getCause()).getSQLException().getErrorCode());
            errorObject.setStatusCode(HttpStatus.BAD_REQUEST);
           errorObject.setTimestamp(ZonedDateTime.now(ZoneId.of("Z")));
            return new ResponseEntity<ErrorResponse>(errorObject, HttpStatus.BAD_REQUEST);
        }
        errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        errorObject.setMessage("Impossible d'exécuter l'opération!");
        errorObject.setTimestamp(ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<ErrorResponse>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex, WebRequest request) {
        return createNotFoundResponse("Entité avec ce paramètre n'existe pas: ", ex);
    }

    @ExceptionHandler(UniqueViolationException.class)
    public ResponseEntity<ErrorResponse> handleUniqueViolationException(UniqueViolationException ex, WebRequest request) {
        return createNotAcceptableResponse("Valeur existe déjà: ", ex);
    }

    private ResponseEntity<ErrorResponse> createNotAcceptableResponse(String message, RuntimeException ex) {
        ErrorResponse errorObject = new ErrorResponse();
        errorObject.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
        errorObject.setMessage(message + ex.getLocalizedMessage());
      //  errorObject.setTimestamp(new Date());
        return new ResponseEntity<ErrorResponse>(errorObject, HttpStatus.NOT_ACCEPTABLE);
    }

    private ResponseEntity<ErrorResponse> createNotFoundResponse(String message, RuntimeException ex) {
        ErrorResponse errorObject = new ErrorResponse();
        errorObject.setStatusCode(HttpStatus.NOT_FOUND);
        errorObject.setMessage(message + ex.getLocalizedMessage());
        //errorObject.setTimestamp(new Date());
        return new ResponseEntity<ErrorResponse>(errorObject, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ParentSimilairToShild.class)
    private ResponseEntity<ErrorResponse> ParentandShiledSimilare(ParentSimilairToShild e) {
        ErrorResponse errorObject = new ErrorResponse();
        errorObject.setStatusCode(HttpStatus.BAD_REQUEST);
        errorObject.setMessage(e.getLocalizedMessage()+" Please select other parent for register this categorie");
        //errorObject.setTimestamp(new Date());
        return new ResponseEntity<ErrorResponse>(errorObject, HttpStatus.BAD_REQUEST);
    }
}
