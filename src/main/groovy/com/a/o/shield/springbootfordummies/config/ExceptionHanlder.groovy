package com.a.o.shield.springbootfordummies.config

import groovy.json.JsonBuilder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHanlder {
    @ExceptionHandler(HttpMessageNotReadableException)
    ResponseEntity handleHttpMessageNotReadableException() {
        new ResponseEntity(new JsonBuilder("Invalid"), HttpStatus.BAD_REQUEST)
    }
}
