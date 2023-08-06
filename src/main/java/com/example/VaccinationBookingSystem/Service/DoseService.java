package com.example.VaccinationBookingSystem.Service;

import com.example.VaccinationBookingSystem.Enum.DoseType;
import com.example.VaccinationBookingSystem.Model.Dose;
import com.example.VaccinationBookingSystem.Model.Person;
import com.example.VaccinationBookingSystem.MyExceotions.DoseAlreadyTakenException;
import com.example.VaccinationBookingSystem.MyExceotions.PersonNotFoundException;
import com.example.VaccinationBookingSystem.Repository.DoseRepository;
import com.example.VaccinationBookingSystem.Repository.PersonRepository;
import com.example.VaccinationBookingSystem.dto.RequestDto.BookDose1RequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    PersonRepository personRepository;

//    public Dose getDose1(int personId, DoseType doseType) {
//        Optional<Person> optionalPerson = personRepository.findById(personId);
//
//        //check if person exists or not
//        if(!optionalPerson.isPresent())
//            throw new PersonNotFoundException("Invalid person ");
//
//        Person person = optionalPerson.get();
//
//        //check if person dose1 taken or not
//        if(person.getDose1Taken())
//            throw new DoseAlreadyTakenException("Dose is already taken");
//
//        Dose dose = new Dose();
//        dose.setDoseId(String.valueOf(UUID.randomUUID()));
//        dose.setDoseType(doseType);
//        dose.setPerson(person);
//        dose.setPerson(person);
//
//        person.setDose1Taken(true);
//        person.getDosesTaken().add(dose);
//        Person savedPerson = personRepository.save(person);
//
//        return savedPerson.getDosesTaken().get(0);
//
//    }

    public Dose getDose1(BookDose1RequestDto bookDose1RequestDto) {
        Optional<Person> optionalPerson = personRepository.findById(bookDose1RequestDto.getPersonId());

        //check if person exists or not
        if(!optionalPerson.isPresent())
            throw new PersonNotFoundException("Invalid person ");

        Person person = optionalPerson.get();

        //check if person dose1 taken or not
        if(person.isDose1Taken()) {
            throw new DoseAlreadyTakenException("Dose is already taken");
        }

        //create a dose from request dto
        Dose dose = new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(bookDose1RequestDto.getDoseType()); // from dto
        dose.setPerson(person);

        person.setDose1Taken(true);
        person.getDosesTaken().add(dose);
        Person savedPerson = personRepository.save(person);

        return savedPerson.getDosesTaken().get(0);

    }
}
