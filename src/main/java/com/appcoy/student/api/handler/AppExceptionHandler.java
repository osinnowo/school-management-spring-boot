package com.appcoy.student.api.handler;

import com.appcoy.student.api.app.BaseResponse;
import com.appcoy.student.api.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.MissingRequestValueException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    final public Mono<ResponseEntity<BaseResponse<?>>> handleAllException(Exception ex, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity(BaseResponse.fail(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(UserNotFoundException.class)
    final public Mono<ResponseEntity<BaseResponse<?>>> handleUserNotFoundException(Exception ex, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity(BaseResponse.fail(ex.getMessage()), HttpStatus.NOT_FOUND));
    }

    @Override
    final public Mono<ResponseEntity<Object>> handleMissingRequestValueException(MissingRequestValueException ex, HttpHeaders headers, HttpStatusCode status, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity(BaseResponse.fail(ex.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @Override
    final public Mono<ResponseEntity<Object>> handleServerWebInputException(ServerWebInputException ex, HttpHeaders headers, HttpStatusCode status, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity(BaseResponse.fail(ex.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @Override
    final public Mono<ResponseEntity<Object>> handleWebExchangeBindException(WebExchangeBindException ex, HttpHeaders headers, HttpStatusCode status, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity(BaseResponse.fail(ex.getFieldError().getDefaultMessage()), HttpStatus.UNPROCESSABLE_ENTITY));
    }
}
