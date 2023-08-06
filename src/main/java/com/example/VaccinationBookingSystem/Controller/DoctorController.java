package com.example.VaccinationBookingSystem.Controller;

import com.example.VaccinationBookingSystem.Service.DoctorService;
import com.example.VaccinationBookingSystem.dto.RequestDto.DoctorRequestDto;
import com.example.VaccinationBookingSystem.dto.ResonseDto.DoctorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctorRequestDto)
    {
        try{
            DoctorResponseDto responseDto = doctorService.addDoctor(doctorRequestDto);
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAgeGreaterThan")
    public List<String> getByAgeGreaterThan(@RequestParam("age") int age){
        List<String> doctors = doctorService.getByAgeGreaterThan(age);
        return doctors;
    }
}
