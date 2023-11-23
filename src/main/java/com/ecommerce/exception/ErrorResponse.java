package com.ecommerce.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private  HttpStatus statusCode;
    private  Throwable throwable;
    private  String message;
    private  Integer errorCode;
    private  ZonedDateTime timestamp;


}
