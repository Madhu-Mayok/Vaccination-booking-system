package com.example.VaccinationBookingSystem.MyExceotions;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(String message)
    {
        super(message);
    }
}
