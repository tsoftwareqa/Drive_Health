package com.drivehealth.test.exceptions.ui;

@SuppressWarnings("serial")
public class CannotAuthenticateException extends RuntimeException {

    public CannotAuthenticateException(String actorName) {
        super("The actor " + actorName + " does not have the ability to sign in to website (system under test)");
    }
}
