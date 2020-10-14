package com.depromeet.dodo.auth.exception;

public class AccessDeniedException extends IllegalArgumentException {

    public AccessDeniedException() {
    }

    public AccessDeniedException(String s) {
        super(s);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }
}
