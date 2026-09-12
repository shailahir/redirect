package com.shailahir.apps.links.exception;

public class ShortLinkAlreadyExistException extends RuntimeException {

    public ShortLinkAlreadyExistException(String message) {
        super(message);
    }
}
