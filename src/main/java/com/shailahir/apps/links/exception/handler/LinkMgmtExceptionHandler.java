package com.shailahir.apps.links.exception.handler;

import com.shailahir.apps.links.exception.ShortLinkAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkMgmtExceptionHandler {

    @ExceptionHandler(ShortLinkAlreadyExistException.class)
    public ResponseEntity<String> handleException(ShortLinkAlreadyExistException ex) {

        // TODO: Handle it better with intl
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
