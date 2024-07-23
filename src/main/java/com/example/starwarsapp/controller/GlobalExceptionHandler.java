package com.example.starwarsapp.controller;

import com.example.starwarsapp.DTO.ErrorDTO;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<ErrorDTO> handleWebClientResponseException(WebClientResponseException e) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .message(e.getResponseBodyAsString())
                .code(String.valueOf(e.getRawStatusCode()))
                .build();

        HttpStatus status = HttpStatus.valueOf(e.getRawStatusCode());
        return new ResponseEntity<>(errorDTO, status);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorDTO> handleBadCredentialsException(BadCredentialsException ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().message("El nombre de usuario o contraseña son incorrectos").code(String.valueOf(HttpStatus.UNAUTHORIZED.value())).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccountStatusException.class)
    public ResponseEntity<ErrorDTO> handleAccountStatusException(AccountStatusException ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().message("La cuenta esta bloqueada").code(String.valueOf(HttpStatus.FORBIDDEN.value())).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ErrorDTO> handleSignatureException(SignatureException ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().message("JWT invalido").code(String.valueOf(HttpStatus.FORBIDDEN.value())).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDTO> handleAccessDeniedException(AccessDeniedException ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().message("No tiene autorizacion para acceder a este recurso").code(String.valueOf(HttpStatus.FORBIDDEN.value())).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ErrorDTO> handleAccessDeniedException(ExpiredJwtException ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().message("JWT a expirado").code(String.valueOf(HttpStatus.FORBIDDEN.value())).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception e) {
        ErrorDTO errorResponse = ErrorDTO.builder().message("Internal Server Error").code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

