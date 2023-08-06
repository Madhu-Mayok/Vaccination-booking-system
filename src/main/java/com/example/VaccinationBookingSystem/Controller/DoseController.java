package com.example.VaccinationBookingSystem.Controller;

import com.example.VaccinationBookingSystem.Enum.DoseType;
import com.example.VaccinationBookingSystem.Model.Dose;
import com.example.VaccinationBookingSystem.MyExceotions.DoseAlreadyTakenException;
import com.example.VaccinationBookingSystem.MyExceotions.PersonNotFoundException;
import com.example.VaccinationBookingSystem.Service.DoseService;
import com.example.VaccinationBookingSystem.dto.RequestDto.BookDose1RequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;

//    @GetMapping("/get_dose_1")
//    public ResponseEntity getDose1(@RequestParam("id") int personId, @RequestParam("doseType") DoseType doseType)
//    {
//        try{
//            Dose doseEntry = doseService.getDose1(personId,doseType);
//            return new ResponseEntity<>(doseEntry,HttpStatus.CREATED);
//        }
//        catch(Exception e)
//        {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//
//    }

    @GetMapping("/get_dose_1")
    public ResponseEntity getDose1(@RequestBody BookDose1RequestDto bookDose1RequestDto)
    {
        try{
            Dose doseEntry = doseService.getDose1(bookDose1RequestDto);
            return new ResponseEntity<>(doseEntry,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
