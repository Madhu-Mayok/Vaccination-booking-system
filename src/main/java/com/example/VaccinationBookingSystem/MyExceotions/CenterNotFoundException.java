package com.example.VaccinationBookingSystem.MyExceotions;

public class CenterNotFoundException extends RuntimeException {
    public  CenterNotFoundException(String message)
    {
        super(message);
    }
}
