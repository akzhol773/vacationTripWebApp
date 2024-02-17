package com.neobis.vacationtrip.exceptions;

public class TripNotExistException extends RuntimeException{
    public TripNotExistException(String message) {
        super(message);
    }
}
