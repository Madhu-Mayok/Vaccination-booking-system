package com.example.VaccinationBookingSystem.Service;

import com.example.VaccinationBookingSystem.Model.Doctor;
import com.example.VaccinationBookingSystem.Model.VaccinationCenter;
import com.example.VaccinationBookingSystem.MyExceotions.CenterNotFoundException;
import com.example.VaccinationBookingSystem.Repository.DoctorRepository;
import com.example.VaccinationBookingSystem.Repository.VaccinationCenterRepository;
import com.example.VaccinationBookingSystem.dto.RequestDto.DoctorRequestDto;
import com.example.VaccinationBookingSystem.dto.ResonseDto.CenterResponseDto;
import com.example.VaccinationBookingSystem.dto.ResonseDto.DoctorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterRepository centerRepository;
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) {

        //check center exist or not by using center id

        Optional<VaccinationCenter> center = centerRepository.findById(doctorRequestDto.getCenterId());

        if(center.isEmpty())
            throw new CenterNotFoundException("Sorry !! Center doesn't exist");

        VaccinationCenter centerFound = center.get();

        //create doctor from dto

        Doctor doctor = new Doctor();
        doctor.setName(doctorRequestDto.getName());
        doctor.setAge(doctorRequestDto.getAge());
        doctor.setEmailId(doctorRequestDto.getEmailId());
        doctor.setGender(doctorRequestDto.getGender());
        doctor.setCenter(centerFound);

        //Add the doctor in center list
        centerFound.getDoctors().add(doctor);

        VaccinationCenter centerSaved = centerRepository.save(centerFound);//this will save both center and doctor bcoz center is parent

        //prepare response dto
        List<Doctor> doctorList = centerSaved.getDoctors();
        Doctor latestSaved = doctorList.get(doctorList.size()-1);

        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();
        doctorResponseDto.setName(latestSaved.getName());
        doctorResponseDto.setMessage("congrats!! You are registered succesfully..");

        CenterResponseDto centerResponseDto = new CenterResponseDto();
        centerResponseDto.setCenterName(centerSaved.getCenterName());
        centerResponseDto.setCenterType(centerSaved.getCenterType());
        centerResponseDto.setAddress(centerSaved.getAddress());

        doctorResponseDto.setCenterDto(centerResponseDto);

        return doctorResponseDto;

    }

    public List<String> getByAgeGreaterThan(int age) {

        List<Doctor> doctors = doctorRepository.getByAgeGreaterThan(age);
        List<String> ans = new ArrayList<>();

        for(Doctor d: doctors)
            ans.add(d.getName());

        return ans;
    }
}
