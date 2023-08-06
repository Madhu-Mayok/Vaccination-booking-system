package com.example.VaccinationBookingSystem.Service;

import com.example.VaccinationBookingSystem.Model.VaccinationCenter;
import com.example.VaccinationBookingSystem.Repository.VaccinationCenterRepository;
import com.example.VaccinationBookingSystem.dto.RequestDto.AddCenterRequestDto;
import com.example.VaccinationBookingSystem.dto.ResonseDto.CenterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository centerRepository;
    public CenterResponseDto addCenter(AddCenterRequestDto centerRequestDto) {

        //Request dto to entity
        VaccinationCenter center = new VaccinationCenter();
        center.setCenterType(centerRequestDto.getCenterType());
        center.setCenterName(centerRequestDto.getCenterName());
        center.setAddress(centerRequestDto.getAddress());

        VaccinationCenter centerSaved = centerRepository.save(center);

        //convert entity to response dto

        CenterResponseDto responseDto = new CenterResponseDto();
        responseDto.setAddress(centerSaved.getAddress());
        responseDto.setCenterName(centerSaved.getCenterName());
        responseDto.setCenterType(centerSaved.getCenterType());

        return responseDto;
    }

}
