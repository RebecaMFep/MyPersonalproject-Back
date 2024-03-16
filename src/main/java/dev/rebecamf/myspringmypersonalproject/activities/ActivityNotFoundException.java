package dev.rebecamf.myspringmypersonalproject.activities;

public class ActivityNotFoundException extends ActivityException{



    public ActivityNotFoundException(String message) {
        super(message);
    }

    public ActivityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
