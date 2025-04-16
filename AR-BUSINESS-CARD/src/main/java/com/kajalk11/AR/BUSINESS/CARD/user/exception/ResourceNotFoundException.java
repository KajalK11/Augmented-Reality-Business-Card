package com.kajalk11.AR.BUSINESS.CARD.user.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String Usernotfound) {
        super(Usernotfound );
    }
}
