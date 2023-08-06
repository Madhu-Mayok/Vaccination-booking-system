package com.example.VaccinationBookingSystem.MyExceotions;

public class DoseAlreadyTakenException extends RuntimeException{
    public DoseAlreadyTakenException(String message)
    {
        super(message);
    }
}
