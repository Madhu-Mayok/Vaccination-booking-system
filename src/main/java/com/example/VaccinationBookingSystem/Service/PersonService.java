package com.example.VaccinationBookingSystem.Service;

import com.example.VaccinationBookingSystem.Model.Person;
import com.example.VaccinationBookingSystem.MyExceotions.PersonNotFoundException;
import com.example.VaccinationBookingSystem.Repository.PersonRepository;
import com.example.VaccinationBookingSystem.dto.RequestDto.AddPersonRequestDto;
import com.example.VaccinationBookingSystem.dto.ResonseDto.AddPersonResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public AddPersonResponseDto addPerson(AddPersonRequestDto addPersonRequestDto) {

        //convert request dto to entity

        Person person = new Person();
        person.setName(addPersonRequestDto.getName());
        person.setAge(addPersonRequestDto.getAge());
        person.setEmailId(addPersonRequestDto.getEmail());
        person.setGender(addPersonRequestDto.getGender());
        //    even if you dont give they have default values for the person registration for first time
        //    person.setDose1Taken(false);
        //    person.setDose2Taken(false);
        //    person.setCertificate(null);

        Person personSaved = personRepository.save(person);// save function returns entire entry/row of the saved peron

        //convert entity to dto

        AddPersonResponseDto addPersonResponseDto = new AddPersonResponseDto();

        addPersonResponseDto.setName(personSaved.getName());
        addPersonResponseDto.setMessage("Congrats ! You have regiested successfully");

        return addPersonResponseDto;
    }

    public String updateEmail(String oldEmail, String newEmail) {

        Person person = personRepository.findByEmailId(oldEmail);
        if(person == null) {
            throw new PersonNotFoundException("Sorry email doesn't exist");
        }

        person.setEmailId(newEmail);
        personRepository.save(person);

        return "Congrats!! Your email has been updated successfully";
    }
}
