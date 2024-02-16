//package com.example.productservice_proxy.controllers;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class HandlingException {
//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<String> handleException(Exception e){
//        return new ResponseEntity<>("something is not right", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
